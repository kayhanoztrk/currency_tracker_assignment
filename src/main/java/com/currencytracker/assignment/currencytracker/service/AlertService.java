package com.currencytracker.assignment.currencytracker.service;

import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;

import java.util.List;

public interface AlertService {
    List<AlertDto> findAll();
    AlertDto createAlert(Long currencyId, Alert alert);
    AlertDto editAlert(Alert alert);
    void deleteAlert(Long id);
    List<Alert> checkReachedPriceAlerts();
    void updateAlertStatusTriggered(Alert alert);
    void updateAlertStatusAcked(Long alertId);
    void updateAlertStatusCanceled(Long alertId);
}
