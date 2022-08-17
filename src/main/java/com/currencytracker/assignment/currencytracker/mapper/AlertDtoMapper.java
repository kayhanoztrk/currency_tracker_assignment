package com.currencytracker.assignment.currencytracker.mapper;

import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;
import org.springframework.stereotype.Component;

@Component
public class AlertDtoMapper {

    public AlertDto convertToDto(Alert alert) {
        return AlertDto.builder()
                .id(alert.getId())
                .targetPrice(alert.getTargetPrice())
                .currencyName(alert.getCurrency().getName())
                .currencySymbol(alert.getCurrency().getSymbol())
                .currencyCurrentPrice(alert.getCurrency().getCurrentPrice())
                .createdAt(alert.getCreatedAt())
                .status(alert.getStatus())
                .build();
    }
}
