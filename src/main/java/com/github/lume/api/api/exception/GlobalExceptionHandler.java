package com.github.lume.api.api.exception;

import com.github.lume.api.api.dto.error.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUserDataException.class)
    public ResponseEntity<ErrorMessage> handleInvalidUserDataException(InvalidUserDataException error) {
        ErrorMessage errorResponse = new ErrorMessage(error.getMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }
}
