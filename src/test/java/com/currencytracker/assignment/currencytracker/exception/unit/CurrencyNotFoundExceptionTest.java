package com.currencytracker.assignment.currencytracker.exception.unit;

import com.currencytracker.assignment.currencytracker.exception.CurrencyNotFoundException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link CurrencyNotFoundException}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since 0.0.1
 */
public class CurrencyNotFoundExceptionTest {

    @Test
    public void when_ExceptionHasOnlyReason_CreateException() {
        CurrencyNotFoundException currencyNotFoundException
                = new CurrencyNotFoundException("message");
        Assert.assertNotNull(currencyNotFoundException);
    }

    @Test
    public void when_ExceptionHasReasonAndThrowable_CreateException() {
        CurrencyNotFoundException currencyNotFoundException
                = new CurrencyNotFoundException("message", new Throwable());
        Assert.assertNotNull(currencyNotFoundException);
    }
}
