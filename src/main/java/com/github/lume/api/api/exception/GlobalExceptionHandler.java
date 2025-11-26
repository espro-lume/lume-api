package com.github.lume.api.api.exception;

import com.github.lume.api.api.dto.error.ErrorMessage;
import com.github.lume.api.api.exception.order.InvalidCourseDataException;
import com.github.lume.api.api.exception.user.InvalidUserDataException;
import com.github.lume.api.api.exception.user.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUserDataException.class)
    public ResponseEntity<ErrorMessage> handleInvalidUserDataException(InvalidUserDataException error) {
        ErrorMessage errorResponse = new ErrorMessage(error.getMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(InvalidUserDataException error) {
        ErrorMessage errorResponse = new ErrorMessage(error.getMessage());
        return ResponseEntity.status(404).body(errorResponse);
    }

    @ExceptionHandler(InvalidCourseDataException.class)
    public ResponseEntity<ErrorMessage> handleInvalidOrderDataException(InvalidCourseDataException error) {
        ErrorMessage errorResponse = new ErrorMessage(error.getMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }
}
