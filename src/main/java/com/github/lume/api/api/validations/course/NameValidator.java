package com.github.lume.api.api.validations.course;

import com.github.lume.api.api.validations.ValidationErrorRegistry;

public interface NameValidator {
    default void validateName(String name) {
        if (name == null || name.isEmpty()) {
            ValidationErrorRegistry.addError("Informe o nome");
            return;
        }
    }
}
