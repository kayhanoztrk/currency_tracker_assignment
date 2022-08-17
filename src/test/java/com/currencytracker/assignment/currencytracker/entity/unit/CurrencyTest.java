package com.currencytracker.assignment.currencytracker.entity.unit;

import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * Unit test for {@link Currency}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class CurrencyTest {

    private Currency currency;
    private Alert alert;

    @Before
    public void setUp() {
        currency = new Currency();
        alert = new Alert();
        alert.setId(2L);
        alert.setTargetPrice("28");

        currency.setId(1L);
        currency.setName("DOLAR");
        currency.setSymbol("$");
        currency.setCurrentPrice("19");
        currency.setEnabled(true);
        currency.setCreatedTime(new Date());
        currency.setAlert(Arrays.asList(alert));
    }

    @Test
    public void testGetter() {
        Assert.assertNotNull(currency);

        Assert.assertNotNull(currency.getId());
        Assert.assertNotNull(currency.getName());
        Assert.assertNotNull(currency.getSymbol());
        Assert.assertNotNull(currency.getCurrentPrice());
        Assert.assertNotNull(currency.getAlert());
        Assert.assertNotNull(currency.getCreatedTime());
        Assert.assertNotNull(currency.getAlert());
    }
}
