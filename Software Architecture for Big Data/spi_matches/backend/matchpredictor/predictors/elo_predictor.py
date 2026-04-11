from typing import Iterable, Dict
from matchpredictor.matchresults.result import Outcome, Fixture, Result, Team
from matchpredictor.predictors.predictor import Predictor, Prediction

DEFAULT_RATING = 1500.0
K_FACTOR = 32.0
HOME_ADVANTAGE = 100.0


def _goal_diff_multiplier(goal_diff: int) -> float:
    """Scale K-factor by margin of victory, diminishing returns."""
    return 1 + (abs(goal_diff) ** 0.6) * 0.3


class EloTable:
    def __init__(self) -> None:
        self.ratings: Dict[str, float] = {}

    def rating_for(self, team: Team) -> float:
        return self.ratings.get(team.name, DEFAULT_RATING)

    def update(self, home_team: Team, away_team: Team, outcome: Outcome, goal_diff: int) -> None:
        home_rating = self.rating_for(home_team) + HOME_ADVANTAGE
        away_rating = self.rating_for(away_team)

        expected_home = 1 / (1 + 10 ** ((away_rating - home_rating) / 400))
        expected_away = 1 - expected_home

        if outcome == Outcome.HOME:
            actual_home, actual_away = 1.0, 0.0
        elif outcome == Outcome.AWAY:
            actual_home, actual_away = 0.0, 1.0
        else:
            actual_home, actual_away = 0.5, 0.5

        k = K_FACTOR * _goal_diff_multiplier(goal_diff)
        self.ratings[home_team.name] = self.rating_for(home_team) + k * (actual_home - expected_home)
        self.ratings[away_team.name] = self.rating_for(away_team) + k * (actual_away - expected_away)


class EloPredictor(Predictor):
    def __init__(self, table: EloTable) -> None:
        self.table = table

    def predict(self, fixture: Fixture) -> Prediction:
        home_rating = self.table.rating_for(fixture.home_team) + HOME_ADVANTAGE
        away_rating = self.table.rating_for(fixture.away_team)

        if home_rating > away_rating:
            return Prediction(outcome=Outcome.HOME)
        elif away_rating > home_rating:
            return Prediction(outcome=Outcome.AWAY)
        else:
            return Prediction(outcome=Outcome.HOME)


def train_elo_predictor(results: Iterable[Result]) -> Predictor:
    table = EloTable()
    for result in results:
        goal_diff = result.home_goals - result.away_goals
        table.update(result.fixture.home_team, result.fixture.away_team, result.outcome, goal_diff)
    return EloPredictor(table)
