package com.currencytracker.assignment.currencytracker.mapper;

import com.currencytracker.assignment.currencytracker.dto.CurrencyDto;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyDtoMapper {

    public CurrencyDto convertToDto(Currency currency){
        return CurrencyDto.builder()
                .id(currency.getId())
                .name(currency.getName())
                .symbol(currency.getSymbol())
                .currentPrice(currency.getCurrentPrice())
                .createdTime(currency.getCreatedTime())
                .enabled(currency.isEnabled())
                .build();
    }
}
