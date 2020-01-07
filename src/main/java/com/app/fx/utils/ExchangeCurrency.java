package com.app.fx.utils;
import com.app.fx.entities.ExchangeRatesMappingEntity;
import com.app.fx.model.Currency;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Component
public class ExchangeCurrency extends Currency {


    private  static final List<ExchangeRatesMappingEntity> list= new ArrayList<>();

    public static void loadFxRates(Consumer<List<ExchangeRatesMappingEntity>> cosumer) {
        cosumer.accept(list);
    }


    @Override
    public BigDecimal getExchangeRates(Currency targetCurrency) {


        BigDecimal exchangeRate=list.stream()
                .filter(fxMapping-> getId().equalsIgnoreCase(fxMapping.getBaseCurrency()) && fxMapping.getTargetCurrency().equalsIgnoreCase(targetCurrency.getId()))
                .findFirst()
                .map(ExchangeRatesMappingEntity::getExchangeRate)
                .orElseThrow(() ->  new RuntimeException("Fx Rate not found"));

      return exchangeRate;
    }


    @Override
    public BigDecimal getExchangeAmount(Currency targetCurrency, BigDecimal baseAmount) {

        BigDecimal exchangeRate=getExchangeRates(targetCurrency);

        return baseAmount.multiply(exchangeRate);
    }

}
