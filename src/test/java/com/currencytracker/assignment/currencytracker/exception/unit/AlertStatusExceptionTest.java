package com.currencytracker.assignment.currencytracker.exception.unit;

import com.currencytracker.assignment.currencytracker.exception.AlertStatusException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link AlertStatusException}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since 0.0.1
 */
public class AlertStatusExceptionTest {

    @Test
    public void when_ExceptionHasOnlyReason_CreateException() {
        AlertStatusException alertStatusException
                = new AlertStatusException("message");
        Assert.assertNotNull(alertStatusException);
    }

    @Test
    public void when_ExceptionHasReasonAndThrowable_CreateException() {
        AlertStatusException alertStatusException
                = new AlertStatusException("message", new Throwable());
        Assert.assertNotNull(alertStatusException);
    }
}
