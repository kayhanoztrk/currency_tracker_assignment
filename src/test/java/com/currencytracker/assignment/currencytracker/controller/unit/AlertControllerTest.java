package com.currencytracker.assignment.currencytracker.controller.unit;

import com.currencytracker.assignment.currencytracker.controller.AlertController;
import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.entity.Status;
import com.currencytracker.assignment.currencytracker.service.AlertService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;


/**
 * Unit test for {@link AlertController}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class AlertControllerTest {

    private AlertController alertController;
    private AlertService alertService;
    private Alert alert;
    private AlertDto alertDto;

    @Before
    public void setUp() {
        alertService = mock(AlertService.class);
        alertController = new AlertController(alertService);

        alert = new Alert();
        alert.setId(2L);
        alert.setTargetPrice("2000");
        alert.setCreatedAt(new Date());

        alertDto = new AlertDto();
        alertDto.setId(1L);
        alertDto.setCurrencyName("btc");
        alertDto.setCurrencySymbol("btc");
        alertDto.setTargetPrice("20000");
        alertDto.setCreatedAt(new Date());
        alertDto.setStatus(Status.NEW);

        when(alertService.findAll()).thenReturn(Arrays.asList(alertDto));
        when(alertService.createAlert(anyLong(), any(Alert.class)))
                .thenReturn(alertDto);
        when(alertService.editAlert(any(Alert.class)))
                .thenReturn(alertDto);
        doNothing().when(alertService).deleteAlert(anyLong());
        doNothing().when(alertService).updateAlertStatusAcked(anyLong());
        doNothing().when(alertService).updateAlertStatusCanceled(anyLong());
    }

    @Test
    public void testFindAll() {
        ResponseEntity<List<AlertDto>> response = alertController.findAll();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testCreate() {
        ResponseEntity<AlertDto> response = alertController.create(1L, alert);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testUpdate() {
        ResponseEntity<AlertDto> response = alertController.update(alert);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testDelete() {
        ResponseEntity<String> response = alertController.delete(1L);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testUpdateAlertStatusAcked() {
        ResponseEntity<String> response = alertController.close(1L);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testUpdateAlertStatusCanceled() {
        ResponseEntity<String> response = alertController.cancel(1L);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }

}
