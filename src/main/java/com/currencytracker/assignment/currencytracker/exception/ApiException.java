package com.currencytracker.assignment.currencytracker.exception;

import java.time.ZonedDateTime;

public class ApiException {
    private final String message;
    private final Throwable throwable;
    private final ZonedDateTime zonedDateTime;

    public ApiException(String message, Throwable throwable, ZonedDateTime zonedDateTime) {
        this.message = message;
        this.throwable = throwable;
        this.zonedDateTime = zonedDateTime;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }
}