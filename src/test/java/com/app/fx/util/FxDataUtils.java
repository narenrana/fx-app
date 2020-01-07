package com.app.fx.util;

import com.app.fx.entities.ExchangeRatesMappingEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FxDataUtils {


    public static List<ExchangeRatesMappingEntity> getFxRateList() {

        List<ExchangeRatesMappingEntity> list= new ArrayList<>();
        ExchangeRatesMappingEntity usdToSgd= new ExchangeRatesMappingEntity();
        usdToSgd.setBaseCurrency("USD");
        usdToSgd.setTargetCurrency("SGD");
        usdToSgd.setExchangeRate(new BigDecimal(1.35));
        list.add(usdToSgd);

        ExchangeRatesMappingEntity usdToInr= new ExchangeRatesMappingEntity();
        usdToInr.setBaseCurrency("USD");
        usdToInr.setTargetCurrency("INR");
        usdToInr.setExchangeRate(new BigDecimal(70.6));
        list.add(usdToInr);

        return list;
    }
}
