package com.app.fx.utils;
import com.app.fx.model.Currency;

import java.math.BigDecimal;


public class ExchangeCurrency extends Currency {


    private BigDecimal exchangeRates;

    private BigDecimal exchangeAmount;


    ExchangeCurrency( String id, String name, BigDecimal exchangeRates) {
        this.setId(id);
        this.setName(name);
        this.exchangeRates=exchangeRates;
    }

    @Override
    public BigDecimal getExchangeRates(Currency targetCurrency) {
        return this.exchangeRates;
    }


    @Override
    public BigDecimal getExchangeAmount(Currency targetCurrency) {

        return this.exchangeAmount;
    }

}
