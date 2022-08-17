package com.currencytracker.assignment.currencytracker.exception.unit;

import com.currencytracker.assignment.currencytracker.exception.UnsupportedCurrencyCreationException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link UnsupportedCurrencyCreationException}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since   0.0.1
 */
public class UnsupportedCurrencyCreationExceptionTest {

    @Test
    public void when_ExceptionHasOnlyReason_CreateException(){
        UnsupportedCurrencyCreationException unsupportedCurrencyCreationException
                = new UnsupportedCurrencyCreationException("message");
        Assert.assertNotNull(unsupportedCurrencyCreationException);
    }

    @Test
    public void when_ExceptionHasReasonAndThrowable_CreateException(){
        UnsupportedCurrencyCreationException unsupportedCurrencyCreationException
                = new UnsupportedCurrencyCreationException("message", new Throwable());
        Assert.assertNotNull(unsupportedCurrencyCreationException);
    }

}
