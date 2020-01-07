package com.app.fx.services.impl;

import com.app.fx.controller.request.FxRequest;
import com.app.fx.controller.response.FXResponse;
import com.app.fx.services.FxService;
import com.app.fx.entities.ExchangeRatesMappingEntity;
import com.app.fx.repository.ExchangeRatesMappingEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to get Fx rates
 */
@Service("fxService")
public class FxServiceImpl implements FxService {

    @Autowired
    private ExchangeRatesMappingEntityRepository exchangeRatesMappingEntityRepository;

    @Override
    public FXResponse getFxRates(FxRequest fxRequest) {

        ExchangeRatesMappingEntity fxMapping= exchangeRatesMappingEntityRepository.findByBaseCurrencyAndTargetCurrency(fxRequest.getBaseCurrency(),fxRequest.getTargetCurrency());

        //ExchangeCurrency exchangeCurrency= new ExchangeCurrency();
       // exchangeCurrency.setId(fxRequest.getBaseCurrency());

        FXResponse response= new FXResponse();
        response.setBaseCurrency(fxRequest.getBaseCurrency());
        response.setTargetCurrency(fxRequest.getTargetCurrency());
        response.setBaseAmount(fxRequest.getBaseAmount());
        response.setExchangeRate(fxMapping.getExchangeRate());
        /**
         * Calculate ExchangeAmount
         */
        response.setExchangeAmount(fxRequest.getBaseAmount().multiply(fxMapping.getExchangeRate()));


        return response;
    }

    @Override
    public List<FXResponse> getAllFxRates() {

        List<FXResponse> response= new ArrayList<>();
        Iterable<ExchangeRatesMappingEntity> fxMappingList= exchangeRatesMappingEntityRepository.findAll();

        fxMappingList.forEach(fxMapping ->{

            FXResponse fxResponse= new FXResponse();
            fxResponse.setBaseCurrency(fxMapping.getBaseCurrency());
            fxResponse.setTargetCurrency(fxMapping.getTargetCurrency());
            fxResponse.setExchangeRate(fxMapping.getExchangeRate());

            response.add(fxResponse);

        });

        return response;
    }

}
