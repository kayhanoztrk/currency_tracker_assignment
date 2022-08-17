package com.currencytracker.assignment.currencytracker.mapper.unit;

import com.currencytracker.assignment.currencytracker.entity.Currency;
import com.currencytracker.assignment.currencytracker.mapper.CurrencyDtoMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Unit test for {@link CurrencyDtoMapper}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since   0.0.1
 */
public class CurrencyDtoMapperTest {

    private CurrencyDtoMapper currencyDtoMapper;
    private Currency currency;

    @Before
    public void setUp(){
        currencyDtoMapper = new CurrencyDtoMapper();
        currency = new Currency();
        currency.setId(1L);
        currency.setName("btc");
        currency.setSymbol("btc");
        currency.setCurrentPrice("20000");
        currency.setCreatedTime(new Date());
    }

    @Test
    public void testConvertToDto(){
        currencyDtoMapper.convertToDto(currency);
        Assert.assertNotNull(currency);
    }
}