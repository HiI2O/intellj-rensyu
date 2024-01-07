package com.example.rensyu03.exceptions;

import lombok.Getter;

public class InvalidValueException extends RuntimeException {
    @Getter
    private final String errorCode;

    public InvalidValueException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
