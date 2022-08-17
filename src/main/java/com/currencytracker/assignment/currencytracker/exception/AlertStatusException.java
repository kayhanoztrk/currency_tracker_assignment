package com.currencytracker.assignment.currencytracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlertStatusException extends RuntimeException {

    public AlertStatusException(String message) {
        super(message);
    }

    public AlertStatusException(String message, Throwable throwable) {
        super(message, throwable);
    }
}