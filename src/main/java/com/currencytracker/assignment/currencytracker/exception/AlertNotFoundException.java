package com.currencytracker.assignment.currencytracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlertNotFoundException extends RuntimeException {

    public AlertNotFoundException(String message) {
        super(message);
    }

    public AlertNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}