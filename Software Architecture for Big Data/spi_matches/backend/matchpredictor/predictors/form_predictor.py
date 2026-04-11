from typing import Iterable, Dict, List, Tuple
from matchpredictor.matchresults.result import Outcome, Fixture, Result, Team
from matchpredictor.predictors.predictor import Predictor, Prediction


class TeamStats:
    def __init__(self) -> None:
        self.history: List[Tuple[float, int]] = []  # (points, goal_diff)
        self.total_points: int = 0

    def record(self, points: float, goal_diff: int) -> None:
        self.history.append((points, goal_diff))
        self.total_points += int(points)

    def form_score(self) -> float:
        if not self.history:
            return 0.0
        total, weight_sum = 0.0, 0.0
        for i, (points, goal_diff) in enumerate(self.history):
            weight = (i + 1) ** 2
            score = points + (goal_diff * 0.3)
            total += score * weight
            weight_sum += weight
        weighted_form = total / weight_sum
        # blend recency-weighted form with overall points strength
        overall = self.total_points / len(self.history)
        return weighted_form * 0.7 + overall * 0.3


class FormTable:
    def __init__(self) -> None:
        self.stats: Dict[str, TeamStats] = {}

    def record_result(self, team: Team, points: float, goal_diff: int) -> None:
        if team.name not in self.stats:
            self.stats[team.name] = TeamStats()
        self.stats[team.name].record(points, goal_diff)

    def form_score(self, team: Team) -> float:
        return self.stats[team.name].form_score() if team.name in self.stats else 0.0


class FormPredictor(Predictor):
    HOME_ADVANTAGE = 1.1

    def __init__(self, table: FormTable) -> None:
        self.table = table

    def predict(self, fixture: Fixture) -> Prediction:
        home_score = self.table.form_score(fixture.home_team) * self.HOME_ADVANTAGE
        away_score = self.table.form_score(fixture.away_team)

        if home_score > away_score:
            return Prediction(outcome=Outcome.HOME)
        elif away_score > home_score:
            return Prediction(outcome=Outcome.AWAY)
        else:
            return Prediction(outcome=Outcome.HOME)


def train_form_predictor(results: Iterable[Result]) -> Predictor:
    table = FormTable()
    for result in results:
        home_diff = result.home_goals - result.away_goals
        if result.outcome == Outcome.HOME:
            table.record_result(result.fixture.home_team, 3, home_diff)
            table.record_result(result.fixture.away_team, 0, -home_diff)
        elif result.outcome == Outcome.AWAY:
            table.record_result(result.fixture.home_team, 0, home_diff)
            table.record_result(result.fixture.away_team, 3, -home_diff)
        else:
            table.record_result(result.fixture.home_team, 1, 0)
            table.record_result(result.fixture.away_team, 1, 0)
    return FormPredictor(table)
