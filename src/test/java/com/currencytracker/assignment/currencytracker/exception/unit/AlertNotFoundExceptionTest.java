package com.currencytracker.assignment.currencytracker.exception.unit;

import com.currencytracker.assignment.currencytracker.exception.AlertNotFoundException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link AlertNotFoundException}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since 0.0.1
 */
public class AlertNotFoundExceptionTest {

    @Test
    public void when_ExceptionHasOnlyReason_CreateException() {
        AlertNotFoundException alertNotFoundException
                = new AlertNotFoundException("message");
        Assert.assertNotNull(alertNotFoundException);
    }

    @Test
    public void when_ExceptionHasReasonAndThrowable_CreateException() {
        AlertNotFoundException alertNotFoundException
                = new AlertNotFoundException("message", new Throwable());
        Assert.assertNotNull(alertNotFoundException);
    }
}
