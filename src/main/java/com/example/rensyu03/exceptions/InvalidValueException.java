package com.example.rensyu03.exceptions;

import lombok.Getter;

@Getter
public class InvalidValueException extends RuntimeException {
    private final String errorCode;

    public InvalidValueException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
