package com.currencytracker.assignment.currencytracker.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
public class CurrencyDto{
    private Long id;
    private String name;
    private String symbol;
    private String currentPrice;
    private Date createdTime;
    private boolean enabled;

    public CurrencyDto(Long id, String name, String symbol,
                       String currentPrice, Date createdTime,
                       boolean enabled){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
        this.createdTime = createdTime;
        this.enabled = enabled;
    }
}
