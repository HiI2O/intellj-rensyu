package com.example.rensyu03.exceptions;

public class InvalidBillingPhoneValueException extends RuntimeException {
    public InvalidBillingPhoneValueException(String message) {
        super(message);
    }
}
