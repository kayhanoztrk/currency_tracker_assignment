package com.currencytracker.assignment.currencytracker.controller.unit;

import com.currencytracker.assignment.currencytracker.controller.CurrencyController;
import com.currencytracker.assignment.currencytracker.dto.CurrencyDto;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import com.currencytracker.assignment.currencytracker.service.CurrencyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Unit test for {@link CurrencyController}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class CurrencyControllerTest {

    private CurrencyController currencyController;
    private CurrencyService currencyService;
    private Currency currency;
    private CurrencyDto currencyDto;

    @Before
    public void setUp() {
        currencyService = mock(CurrencyService.class);
        currencyController = new CurrencyController(currencyService);

        currency = new Currency();
        currency.setId(1L);
        currency.setName("btc");
        currency.setSymbol("btc");
        currency.setCurrentPrice("10000");
        currency.setCreatedTime(new Date());
        currency.setEnabled(true);

        currencyDto = new CurrencyDto();
        currencyDto.setId(1L);
        currencyDto.setName("btc");
        currencyDto.setSymbol("btc");
        currencyDto.setEnabled(true);
        currencyDto.setCurrentPrice("20000");
        currencyDto.setCreatedTime(new Date());

        when(currencyService.getCurrencyList()).thenReturn(Arrays.asList(currencyDto));
        when(currencyService.createCurrency(any(Currency.class))).thenReturn(currencyDto);
        when(currencyService.updateCurrency(any(Currency.class)))
                .thenReturn(currencyDto);
        doNothing().when(currencyService).deleteCurrency(anyLong());
    }

    @Test
    public void testFindAll() {
        ResponseEntity<List<CurrencyDto>> response = currencyController.findAll();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testCreate() {
        ResponseEntity<CurrencyDto> response = currencyController.create(currency);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testUpdate(){
        ResponseEntity<CurrencyDto> response = currencyController.update(currency);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testDelete() {
        ResponseEntity<String> response = currencyController.delete(1L);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }
}
