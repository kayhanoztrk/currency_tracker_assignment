package com.currencytracker.assignment.currencytracker.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "alert")
@Data
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @NotNull(message = "TargetPrice should not be null")
    private String targetPrice;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Status status;
}


