package com.currencytracker.assignment.currencytracker.exception.unit;
import  com.currencytracker.assignment.currencytracker.exception.ApiException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * Unit test for {@link ApiException}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since   0.0.1
 */
public class ApiExceptionTest {

    ApiException apiException;
    @Before
    public void setUp(){
        apiException = new ApiException("message", new Throwable(), ZonedDateTime.now());
    }


    @Test
    public void when_ExceptionHasReason_CreateException(){
        Assert.assertNotNull(apiException);

        Assert.assertNotNull(apiException.getMessage());
        Assert.assertNotNull(apiException.getThrowable());
        Assert.assertNotNull(apiException.getZonedDateTime());
    }

    @Test
    public void testGetMessage(){
        Assert.assertNotNull(apiException.getMessage());
    }

}
