package com.github.lume.api.api.dto.error;

import com.github.lume.api.api.exception.InvalidUserDataException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private String message;
}
