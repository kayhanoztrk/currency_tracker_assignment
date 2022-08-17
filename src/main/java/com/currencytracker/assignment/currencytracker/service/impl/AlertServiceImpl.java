package com.currencytracker.assignment.currencytracker.service.impl;

import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import com.currencytracker.assignment.currencytracker.entity.Status;
import com.currencytracker.assignment.currencytracker.exception.AlertNotFoundException;
import com.currencytracker.assignment.currencytracker.exception.AlertStatusException;
import com.currencytracker.assignment.currencytracker.mapper.AlertDtoMapper;
import com.currencytracker.assignment.currencytracker.repository.AlertRepository;
import com.currencytracker.assignment.currencytracker.service.AlertService;
import com.currencytracker.assignment.currencytracker.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;
    private final CurrencyService currencyService;
    private final AlertDtoMapper alertDtoMapper;

    public AlertServiceImpl(AlertRepository alertRepository,
                            CurrencyService currencyService,
                            AlertDtoMapper alertDtoMapper) {
        this.alertRepository = alertRepository;
        this.currencyService = currencyService;
        this.alertDtoMapper = alertDtoMapper;
    }

    @Override
    public List<AlertDto> findAll() {
        return alertRepository.findAllJustAlertList();
    }

    @Override
    public AlertDto createAlert(Long currencyId, Alert alert) {
        Currency currency = currencyService.findById(currencyId);

        alert.setCurrency(currency);
        alert.setCreatedAt(new Date());
        alert.setStatus(Status.NEW);
        alertRepository.save(alert);
        return alertDtoMapper.convertToDto(alert);
    }

    @Override
    public AlertDto editAlert(Alert alert) {
        Alert alertFromDb = alertRepository.findById(alert.getId())
                .orElseThrow(() -> new AlertNotFoundException(alert.getId() + " alertId not found!"));
        alertFromDb.setCurrency(alert.getCurrency());
        alertFromDb.setStatus(alert.getStatus());
        alertFromDb.setTargetPrice(alert.getTargetPrice());
        alertRepository.save(alertFromDb);

        return alertDtoMapper.convertToDto(alert);
    }

    @Override
    public void deleteAlert(Long id) {
        alertRepository.deleteById(id);
    }

    @Override
    public List<Alert> checkReachedPriceAlerts() {
        List<Alert> alertList =  alertRepository.checkReachedPriceAlerts();
        return alertList;
    }

    @Override
    public void updateAlertStatusTriggered(Alert alert) {
        Alert alertFromDb = alertRepository.findById(alert.getId())
                .orElseThrow(() -> new AlertNotFoundException(alert.getId() + " alertId not found"));
        alertFromDb.setStatus(Status.TRIGGERED);
        alertRepository.save(alertFromDb);
    }

    @Override
    public void updateAlertStatusAcked(Long alertId) {
        Alert alertFromDb = alertRepository.findById(alertId)
                .orElseThrow(() -> new AlertNotFoundException(alertId + " alertId not found"));

        if (alertFromDb.getStatus() == Status.TRIGGERED) {
            alertFromDb.setStatus(Status.ACKED);
            alertRepository.save(alertFromDb);
        }else{
            throw new AlertStatusException(alertId + " is not triggered yet. " +
                    "You can not acked action!");
        }
    }

    @Override
    public void updateAlertStatusCanceled(Long alertId) {
        Alert alertFromDb = alertRepository.findById(alertId)
                .orElseThrow(() -> new AlertNotFoundException(alertId + " alertId not found"));

        if (alertFromDb.getStatus() != Status.TRIGGERED) {
            alertFromDb.setStatus(Status.CANCELED);
            alertRepository.save(alertFromDb);
        }else{
            throw new AlertStatusException(alertId + " is triggered. You can not cancel!");
        }
    }
}
