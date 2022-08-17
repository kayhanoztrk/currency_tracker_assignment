package com.currencytracker.assignment.currencytracker.service.impl;

import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.mapper.AlertDtoMapper;
import com.currencytracker.assignment.currencytracker.service.AlertService;
import com.currencytracker.assignment.currencytracker.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final AlertService alertService;

    public NotificationServiceImpl(AlertService alertService) {
        this.alertService = alertService;
    }

    @Override
    public List<AlertDto> emailNotification() {
        return null;
    }

    @Override
    public List<AlertDto> pushNotification() {
        return null;
    }

    @Override
    public List<Alert> logNotification() {
        return alertService.checkReachedPriceAlerts();
    }

    @Override
    public void notifiedNotification(Alert alert) {
        alertService.updateAlertStatusTriggered(alert);
    }
}
