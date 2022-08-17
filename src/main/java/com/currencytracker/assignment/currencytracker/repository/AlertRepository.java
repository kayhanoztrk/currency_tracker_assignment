package com.currencytracker.assignment.currencytracker.repository;

import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    @Query(value = "SELECT * FROM currency_tracker.alert as alert, currency_tracker.currency as currency\n" +
            "WHERE currency.id = alert.currency_id AND currency.current_price = alert.target_price AND " +
            " alert.status = 'NEW'",
    nativeQuery = true)
    @Transactional
    List<Alert> checkReachedPriceAlerts();

    @Query(value = "SELECT new com.currencytracker.assignment.currencytracker.dto.AlertDto(a.id, a.targetPrice, a.currency.name, a.currency.symbol, " +
            "a.currency.currentPrice, a.createdAt, a.status" +
            ") FROM Alert a")
    List<AlertDto> findAllJustAlertList();

}
