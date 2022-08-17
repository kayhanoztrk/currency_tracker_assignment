package com.currencytracker.assignment.currencytracker.repository;

import com.currencytracker.assignment.currencytracker.dto.CurrencyDto;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    @Query(value = "SELECT new com.currencytracker.assignment.currencytracker.dto.CurrencyDto(c.id, c.name, c.symbol, c.currentPrice, c.createdTime,c.enabled) FROM Currency c")
    List<CurrencyDto> findAllJustCurrenyList();
}
