package com.currencytracker.assignment.currencytracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedCurrencyCreationException extends RuntimeException {

    public UnsupportedCurrencyCreationException(String message) {
        super(message);
    }

    public UnsupportedCurrencyCreationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
