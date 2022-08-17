package com.currencytracker.assignment.currencytracker.dto.unit;

import com.currencytracker.assignment.currencytracker.dto.CurrencyDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Unit test for {@link CurrencyDto}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class CurrencyDtoTest {

    private CurrencyDto currencyDto;

    @Before
    public void setUp(){
        currencyDto = new CurrencyDto();
        currencyDto.setId(1L);
        currencyDto.setName("Name");
        currencyDto.setCurrentPrice("19");
        currencyDto.setEnabled(true);
        currencyDto.setSymbol("BTC");
        currencyDto.setCreatedTime(new Date());
    }

    @Test
    public void testGetter(){
        Assert.assertNotNull(currencyDto);

        Assert.assertNotNull(currencyDto.getId());
        Assert.assertNotNull(currencyDto.getName());
        Assert.assertNotNull(currencyDto.getCurrentPrice());
        Assert.assertNotNull(currencyDto.isEnabled());
        Assert.assertNotNull(currencyDto.getSymbol());
        Assert.assertNotNull(currencyDto.getCreatedTime());

    }

    @Test
    public void testAllArgsConstructor(){
        currencyDto = new CurrencyDto(1L, "btc","btc","20",
                new Date(), true);

        Assert.assertNotNull(currencyDto);
    }
}
