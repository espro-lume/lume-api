package com.github.lume.api.api.validations.course;

import com.github.lume.api.api.validations.ValidationErrorRegistry;

public interface TitleValidator {
    default void validateTitle(String request) {
        if(request == null || request.isEmpty()) {
            ValidationErrorRegistry.addError("Informe o titulo");
        }
    }
}
