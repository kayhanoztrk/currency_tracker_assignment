package com.currencytracker.assignment.currencytracker.service;

import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;

import java.util.List;

public interface NotificationService {
    List<AlertDto> emailNotification();

    List<AlertDto> pushNotification();

    List<Alert> logNotification();

    void notifiedNotification(Alert alert);
}
