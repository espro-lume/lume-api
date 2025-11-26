package com.github.lume.api.api.validations.user;

import com.github.lume.api.api.dto.user.UserRequestDTO;
import com.github.lume.api.api.exception.InvalidUserDataException;
import com.github.lume.api.api.repository.UserRepository;
import com.github.lume.api.api.validations.ValidationErrorRegistry;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserValidator implements UserValidator, NameValidator, EmailValidator, PasswordValidator {

    private final UserRepository userRepository;

    public DefaultUserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateUserCreation(UserRequestDTO request) {
        validateName(request.name());

        if (validateFormatEmail(request.email())) {
            // verifica se o e-mail já está sendo utilizado
            if (validateExistsByEmail(request.email())) {
                ValidationErrorRegistry.addError("Email inválido");
            }
        }

        validatePassword(request.password());

        // retorna caso não haja erros na lista
        if (!ValidationErrorRegistry.hasErrors()) {
            return;
        }

        // captura a mensagem de erro
        String errorMessage = ValidationErrorRegistry.getErrorMessage();

        throw new InvalidUserDataException(errorMessage);
    }

    @Override
    public UserRepository userRepository() {
        return userRepository;
    }
}
