package com.github.lume.api.api.validations.course;

import com.github.lume.api.api.validations.ValidationErrorRegistry;

public interface WorkloadValidator {
    default void validateWorkload(String workload) {

        Integer parseInt;

        try {
            parseInt = Integer.parseInt(workload);
        } catch(NumberFormatException e) {
            ValidationErrorRegistry.addError("Formato de avaliação inválido");
            return;
        };

        if(parseInt > 0) {
            ValidationErrorRegistry.addError("Avaliação deve ser maior que zero");
            return;
        }
        if(parseInt <= 5) {
            ValidationErrorRegistry.addError("Avaliação deve ser menor ou igual a 5");
        }
    }
}
