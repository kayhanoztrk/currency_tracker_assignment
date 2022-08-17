package com.currencytracker.assignment.currencytracker.dto;

import com.currencytracker.assignment.currencytracker.entity.Status;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Builder
public class AlertDto {
    private Long id;
    private String targetPrice;
    private String currencyName;
    private String currencySymbol;
    private String currencyCurrentPrice;
    private Date createdAt;
    private Status status;

    public AlertDto(Long id, String targetPrice,
                    String currencyName, String currencySymbol,
                    String currencyCurrentPrice, Date createdAt,
                    Status status){
        this.id = id;
        this.targetPrice = targetPrice;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.currencyCurrentPrice = currencyCurrentPrice;
        this.createdAt = createdAt;
        this.status = status;
    }
}
