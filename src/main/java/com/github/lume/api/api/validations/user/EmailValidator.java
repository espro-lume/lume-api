package com.github.lume.api.api.validations.user;

import com.github.lume.api.api.repository.UserRepository;
import com.github.lume.api.api.validations.ValidationErrorRegistry;

public interface EmailValidator {
    UserRepository userRepository();

    // Valida o formato do e-mail
    default boolean validateFormatEmail(String email) { // implementacao
        if(email == null || email.isBlank()){
            ValidationErrorRegistry.addError("E-mail não pode ser vazio");
            return false;
        };

        String emailRegex = "^[\\w-\\.']+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if(!email.matches(emailRegex)){
            ValidationErrorRegistry.addError("Formato de e-mail inválido");
            return false;
        };

        return true;
    }

    default boolean validateExistsByEmail(String email) {
        return userRepository().existsByEmail(email);
    }
}
