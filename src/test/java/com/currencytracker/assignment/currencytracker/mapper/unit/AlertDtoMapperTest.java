package com.currencytracker.assignment.currencytracker.mapper.unit;

import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import com.currencytracker.assignment.currencytracker.entity.Status;
import com.currencytracker.assignment.currencytracker.mapper.AlertDtoMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Unit test for {@link AlertDtoMapper}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since   0.0.1
 */
public class AlertDtoMapperTest {

    private AlertDtoMapper alertDtoMapper;
    private Alert alert;
    private Currency currency;

    @Before
    public void setUp(){
        alertDtoMapper = new AlertDtoMapper();

        currency = new Currency();
        currency.setId(1L);
        currency.setName("BTC");
        currency.setSymbol("BTC");
        currency.setEnabled(true);

        alert = new Alert();
        alert.setId(1L);
        alert.setTargetPrice("30000");
        alert.setCurrency(currency);
        alert.setCreatedAt(new Date());
        alert.setStatus(Status.NEW);
    }

    @Test
    public void testConvertToDto(){
        alertDtoMapper.convertToDto(alert);
        Assert.assertNotNull(alert);
    }
}
