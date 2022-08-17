package com.currencytracker.assignment.currencytracker.exception.unit;

import com.currencytracker.assignment.currencytracker.exception.ApiExceptionHandler;
import com.currencytracker.assignment.currencytracker.exception.UnsupportedCurrencyCreationException;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link ApiExceptionHandler}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since   0.0.1
 */
public class ApiExceptionHandlerTest {

    ApiExceptionHandler apiExceptionHandler;
    UnsupportedCurrencyCreationException unsupportedCurrencyCreationException;

    @Before
    public void setUp() {
        unsupportedCurrencyCreationException = new UnsupportedCurrencyCreationException("message");
        apiExceptionHandler = new ApiExceptionHandler();
    }

    @Test
    public void testHandleApiRequestException() {
        apiExceptionHandler.handleApiRequestException(unsupportedCurrencyCreationException);
    }
}
