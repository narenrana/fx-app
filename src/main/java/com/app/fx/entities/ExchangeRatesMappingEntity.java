package com.app.fx.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "exchange_rates_mapping", schema = "", catalog = "")
@Data
public class ExchangeRatesMappingEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;

    @Basic
    @Column(name = "baseCurrency", nullable = false)
    private String baseCurrency;

    @Basic
    @Column(name = "targetCurrency", nullable = false)
    private String targetCurrency;

    @Basic
    @Column(name = "exchangeRate", nullable = true)
    private BigDecimal exchangeRate;

    @Basic
    @Column(name = "last_updated", nullable = true)
    private Timestamp lastUpdated;


}