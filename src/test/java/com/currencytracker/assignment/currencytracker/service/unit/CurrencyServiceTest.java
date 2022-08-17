package com.currencytracker.assignment.currencytracker.service.unit;

import com.currencytracker.assignment.currencytracker.dto.CurrencyDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import com.currencytracker.assignment.currencytracker.exception.UnsupportedCurrencyCreationException;
import com.currencytracker.assignment.currencytracker.mapper.CurrencyDtoMapper;
import com.currencytracker.assignment.currencytracker.repository.CurrencyRepository;
import com.currencytracker.assignment.currencytracker.service.CurrencyService;
import com.currencytracker.assignment.currencytracker.service.impl.CurrencyServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * Unit test for {@link CurrencyService}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since 0.0.1
 */
public class CurrencyServiceTest {
    private CurrencyService currencyService;
    private CurrencyRepository currencyRepository;
    private CurrencyDtoMapper currencyDtoMapper;
    private Currency currency;
    private Alert alert;
    private CurrencyDto currencyDto;

    @Before
    public void setUp() {
        currencyRepository = mock(CurrencyRepository.class);
        currencyDtoMapper = mock(CurrencyDtoMapper.class);
        currencyService = new CurrencyServiceImpl(currencyRepository,
                currencyDtoMapper);

        alert = new Alert();
        alert.setId(2L);
        alert.setTargetPrice("targetPrice");

        currency = new Currency();
        currency.setId(1L);
        currency.setName("btc");
        currency.setSymbol("btc");
        currency.setCurrentPrice("currentPrice");
        currency.setEnabled(true);
        currency.setCreatedTime(new Date());
        currency.setAlert(Arrays.asList(alert));

        currencyDto = new CurrencyDto();
        currencyDto.setId(12L);
        currencyDto.setName("btc");
        currencyDto.setSymbol("btc");
    }

    @Test
    public void when_CurrencyNameNotInBlackList_CreateCurrency() {
        currencyService.createCurrency(currency);
        Assert.assertNotNull(currency);
    }

    @Test(expected = UnsupportedCurrencyCreationException.class)
    public void when_CurrencyNameInBlackList_CreateCurrency() {
        currency.setName("ETH");
        currencyService.createCurrency(currency);
        Assert.assertNotNull(currency);
    }

    @Test
    public void whenCurrencyIdExist_testDeleteCurrency() {
        Long currencyId = 10L;
        when(currencyRepository.findById(currencyId)).thenReturn(Optional.of(currency));
        currencyService.deleteCurrency(currencyId);
        Assert.assertNotNull(currencyId);
    }

    @Test(expected = RuntimeException.class)
    public void whenCurrencyIdNotFound_testDeleteCurrency() {
        Long currencyId = 30000L;
        currencyService.deleteCurrency(currencyId);
    }

    @Test
    public void testGetCurrencyList() {
        when(currencyRepository.findAllJustCurrenyList())
                .thenReturn(Arrays.asList(currencyDto));
        List<CurrencyDto> currencyDtoList =
                currencyService.getCurrencyList();

        Assert.assertNotNull(currencyDtoList);
    }

    @Test
    public void whenCurrencyId_testFindById() {
        Long currencyId = 19L;
        when(currencyRepository.findById(currencyId))
                .thenReturn(Optional.ofNullable(currency));
        Currency currencyFrom = currencyService.findById(currencyId);
        Assert.assertNotNull(currencyFrom);
    }

    @Test
    public void testUpdateCurrency() {
        when(currencyRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(currency));
        currencyService.updateCurrency(currency);
        Assert.assertNotNull(currency);
    }

}