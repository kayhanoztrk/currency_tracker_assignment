package com.currencytracker.assignment.currencytracker.service.unit;

import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.entity.Status;
import com.currencytracker.assignment.currencytracker.service.AlertService;
import com.currencytracker.assignment.currencytracker.service.NotificationService;
import com.currencytracker.assignment.currencytracker.service.impl.NotificationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Unit test for {@link NotificationService}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since   0.0.1
 */
public class NotificationServiceTest {

    private NotificationService notificationService;
    private AlertService alertService;
    private Alert alert;

    @Before
    public void setUp(){
        alertService = Mockito.mock(AlertService.class);
        notificationService = new NotificationServiceImpl(alertService);

        alert = new Alert();
        alert.setId(1L);
        alert.setTargetPrice("2000");
        alert.setStatus(Status.NEW);
        alert.setCreatedAt(new Date());

        when(alertService.checkReachedPriceAlerts())
                .thenReturn(Arrays.asList(alert));

        doNothing().when(alertService).updateAlertStatusTriggered(any(Alert.class));

    }

    @Test
    public void testLogNotification(){
        List<Alert> alertList = notificationService.logNotification();
        Assert.assertNotNull(alertList);
    }

    @Test
    public void testEmailNotification(){
        List<AlertDto> alertList = notificationService.emailNotification();
        Assert.assertNull(alertList);
    }

    @Test
    public void testPushNotification(){
        List<AlertDto> alertList = notificationService.pushNotification();
        Assert.assertNull(alertList);
    }

    @Test
    public void testNotifiedNotification(){
        notificationService.notifiedNotification(alert);
        Assert.assertNotNull(alert);
    }

}
