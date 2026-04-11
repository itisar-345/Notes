from unittest import TestCase

from matchpredictor.evaluation.evaluator import Evaluator
from matchpredictor.matchresults.results_provider import training_results, validation_results
from matchpredictor.predictors.form_predictor import train_form_predictor
from test.predictors import csv_location


class TestFormPredictor(TestCase):
    def test_accuracy(self) -> None:
        epl = lambda r: r.fixture.league == 'Barclays Premier League'
        training_data = training_results(csv_location, 2019, result_filter=lambda r: epl(r) and r.season >= 2016)
        validation_data = validation_results(csv_location, 2019, result_filter=epl)
        predictor = train_form_predictor(training_data)

        accuracy, _ = Evaluator(predictor).measure_accuracy(validation_data)

        self.assertGreaterEqual(accuracy, .50)
