package com.currencytracker.assignment.currencytracker.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "currency")
@Data
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name field should not be null")
    private String name;
    @NotNull(message = "Symbol field should not be null")
    private String symbol;
    @NotNull(message = "CurrentPrice should not be null")
    private String currentPrice;

    @Temporal(TemporalType.DATE)
    private Date createdTime;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE, mappedBy = "currency")
    private List<Alert> alert;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean enabled = true;
}
