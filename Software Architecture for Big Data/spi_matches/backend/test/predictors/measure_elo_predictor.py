from unittest import TestCase

from matchpredictor.evaluation.evaluator import Evaluator
from matchpredictor.matchresults.results_provider import training_results, validation_results
from matchpredictor.predictors.elo_predictor import train_elo_predictor
from test.predictors import csv_location


class TestEloPredictor(TestCase):
    def test_accuracy(self) -> None:
        epl = lambda r: r.fixture.league == 'Barclays Premier League'
        training_data = training_results(csv_location, 2019, result_filter=epl)
        validation_data = validation_results(csv_location, 2019, result_filter=epl)
        predictor = train_elo_predictor(training_data)

        accuracy, _ = Evaluator(predictor).measure_accuracy(validation_data)

        self.assertGreaterEqual(accuracy, .50)
