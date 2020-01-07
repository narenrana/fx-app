package com.app.fx.model;

import java.math.BigDecimal;

public interface TradingCurrency {

   BigDecimal getExchangeRates( Currency targetCurrency );

   BigDecimal getExchangeAmount( Currency targetCurrency ,BigDecimal amount);

}
