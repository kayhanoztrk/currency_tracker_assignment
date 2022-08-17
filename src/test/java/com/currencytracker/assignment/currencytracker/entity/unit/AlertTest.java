package com.currencytracker.assignment.currencytracker.entity.unit;

import com.currencytracker.assignment.currencytracker.dto.CurrencyDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import com.currencytracker.assignment.currencytracker.entity.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Unit test for {@link Alert}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class AlertTest {

    private Alert alert;
    private Currency currency;

    @Before
    public void setUp(){
        alert = new Alert();
        currency = new Currency();
        currency.setId(1L);
        currency.setName("BTC");
        currency.setSymbol("BTC");

        alert.setId(1L);
        alert.setTargetPrice("targetPrice");
        alert.setCurrency(currency);
        alert.setStatus(Status.NEW);
        alert.setCreatedAt(new Date());
    }

    @Test
    public void testGetter(){
        Assert.assertNotNull(alert);

        Assert.assertNotNull(alert.getId());
        Assert.assertNotNull(alert.getCurrency());
        Assert.assertNotNull(alert.getStatus());
        Assert.assertNotNull(alert.getTargetPrice());
        Assert.assertNotNull(alert.getCreatedAt());
    }
}
