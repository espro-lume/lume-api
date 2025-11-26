package com.github.lume.api.api.validations.course;

import com.github.lume.api.api.validations.ValidationErrorRegistry;

public interface DescriptionValidator {
    default void validateDescription(String description) {
        if(description == null || description.isEmpty()) {
            ValidationErrorRegistry.addError("Informe o nome do curso");
            return;
        }

        if(description.length() < 10) {
            ValidationErrorRegistry.addError("Descrição do curso deve conter no mínimo 10 caracteres.");
        }
    }
}
