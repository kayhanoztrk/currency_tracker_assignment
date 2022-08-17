package com.currencytracker.assignment.currencytracker.service;

import com.currencytracker.assignment.currencytracker.dto.CurrencyDto;
import com.currencytracker.assignment.currencytracker.entity.Currency;

import java.util.List;

public interface CurrencyService {
    CurrencyDto createCurrency(Currency currency);
    CurrencyDto updateCurrency(Currency currency);
    void deleteCurrency(Long id);
    List<CurrencyDto> getCurrencyList();
    Currency findById(Long id);
}
