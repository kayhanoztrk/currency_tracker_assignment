package com.currencytracker.assignment.currencytracker.service.unit;

import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import com.currencytracker.assignment.currencytracker.entity.Status;
import com.currencytracker.assignment.currencytracker.exception.AlertStatusException;
import com.currencytracker.assignment.currencytracker.mapper.AlertDtoMapper;
import com.currencytracker.assignment.currencytracker.repository.AlertRepository;
import com.currencytracker.assignment.currencytracker.service.AlertService;
import com.currencytracker.assignment.currencytracker.service.CurrencyService;
import com.currencytracker.assignment.currencytracker.service.impl.AlertServiceImpl;
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
 * Unit test for {@link AlertService}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since 0.0.1
 */
public class AlertServiceTest {

    private AlertService alertService;
    private AlertRepository alertRepository;
    private CurrencyService currencyService;
    private AlertDtoMapper alertDtoMapper;
    private Alert alert;
    private AlertDto alertDto;
    private Currency currency;

    @Before
    public void setUp() {
        alertRepository = mock(AlertRepository.class);
        currencyService = mock(CurrencyServiceImpl.class);
        alertDtoMapper = mock(AlertDtoMapper.class);

        alertService = new AlertServiceImpl(alertRepository,
                currencyService, alertDtoMapper);

        alert = new Alert();
        alert.setId(2L);
        alert.setTargetPrice("2000");
        alert.setCreatedAt(new Date());
        alert.setStatus(Status.NEW);

        currency = new Currency();
        currency.setId(2L);
        currency.setName("btc");
        currency.setSymbol("btc");
        currency.setEnabled(true);

        alertDto = new AlertDto();
        alertDto.setId(1L);
        alertDto.setCurrencyName("btc");
        alertDto.setTargetPrice("20000");
        alertDto.setCurrencySymbol("btc");

        when(alertRepository.findAllJustAlertList())
                .thenReturn(Arrays.asList(alertDto));

        when(currencyService.findById(1L))
                .thenReturn(currency);
        when(alertRepository.save(any(Alert.class)))
                .thenReturn(alert);

        doNothing().when(alertRepository).deleteById(1L);

        when(alertRepository.checkReachedPriceAlerts())
                .thenReturn(Arrays.asList(alert));

        when(alertRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(alert));

        when(alertRepository.save(any(Alert.class)))
                .thenReturn(alert);

        when(alertDtoMapper.convertToDto(any(Alert.class)))
                .thenReturn(alertDto);
    }

    @Test
    public void testFindAll() {
        List<AlertDto> alertDtoList = alertService.findAll();
        Assert.assertNotNull(alertDtoList);
    }

    @Test
    public void testCreateAlert() {
        AlertDto alertCreated = alertService.createAlert(1L, alert);
        Assert.assertNotNull(alertCreated);
    }

    @Test
    public void testEditAlert() {
        AlertDto editedAlert = alertService.editAlert(alert);
        Assert.assertNotNull(editedAlert);
    }

    @Test
    public void testDeleteAlert() {
        Long alertId = 1L;
        alertService.deleteAlert(alertId);
        Assert.assertNotNull(alertId);
    }

    @Test
    public void testCheckReachedPriceAlerts() {
        List<Alert> alertList = alertService.checkReachedPriceAlerts();
        Assert.assertNotNull(alertList);
    }

    @Test
    public void testUpdateAlertStatusTriggered() {
        alertService.updateAlertStatusTriggered(alert);
        Assert.assertNotNull(alert);
    }

    @Test
    public void when_StatusTriggered_UpdateAlertStatusAcked() {
        alert.setStatus(Status.TRIGGERED);
        when(alertRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(alert));

        alertService.updateAlertStatusAcked(1L);
        Assert.assertNotNull(alert);
    }

    @Test(expected = AlertStatusException.class)
    public void when_StatusNotTriggered_UpdateAlertStatusAcked() {
        alertService.updateAlertStatusAcked(1L);
    }

    @Test
    public void when_StatusNotTriggered_UpdateAlertStatusCanceled() {
        Long alertId = 1L;
        alertService.updateAlertStatusCanceled(alertId);
        Assert.assertNotNull(alertId);
    }

    @Test(expected = AlertStatusException.class)
    public void when_StatusTriggered_UpdateAlertStatusCanceled() {
        alert.setStatus(Status.TRIGGERED);
        when(alertRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(alert));
        alertService.updateAlertStatusCanceled(1L);
    }
}
