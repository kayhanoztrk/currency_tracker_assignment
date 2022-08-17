package com.currencytracker.assignment.currencytracker.dto.unit;

import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Unit test for {@link AlertDto}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class AlertDtoTest {

    private AlertDto alertDto;

    @Before
    public void setUp(){
        alertDto = new AlertDto();
        alertDto.setId(1L);
        alertDto.setCurrencyName("BTC");
        alertDto.setCurrencySymbol("BTC");
        alertDto.setCurrencyCurrentPrice("8");
        alertDto.setTargetPrice("10");
        alertDto.setStatus(Status.NEW);
        alertDto.setCreatedAt(new Date());
    }

    @Test
    public void testGetter(){
        Assert.assertNotNull(alertDto);

        Assert.assertNotNull(alertDto.getId());
        Assert.assertNotNull(alertDto.getCurrencyName());
        Assert.assertNotNull(alertDto.getCurrencySymbol());
        Assert.assertNotNull(alertDto.getTargetPrice());
        Assert.assertNotNull(alertDto.getStatus());
        Assert.assertNotNull(alertDto.getCreatedAt());
    }

    @Test
    public void allArgsConstructor(){
        AlertDto alertDto = new AlertDto(1L,"20000","BTC",
                "btc","10000",new Date(),
                Status.NEW);
        Assert.assertNotNull(alertDto);
    }
}
