package com.app.fx.model;
import java.math.BigDecimal;

public class ExchangeCurrency extends Currency {


    private BigDecimal exchangeRates;

    private BigDecimal exchangeAmount;


    @Override
    public BigDecimal getExchangeRates(Currency targetCurrency) {
        return this.exchangeRates;
    }

    @Override
    public BigDecimal getExchangeAmount(Currency targetCurrency) {

        return this.exchangeAmount;
    }

}
