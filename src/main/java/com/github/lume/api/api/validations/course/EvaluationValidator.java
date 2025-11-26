package com.github.lume.api.api.validations.course;

public interface EvaluationValidator {
    default void validateEvaluation(String evaluation) {
        try {
            Double.parseDouble(evaluation);
        } catch (NumberFormatException e) {

        }
    }
}
