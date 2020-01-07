package com.app.fx.services;

import com.app.fx.controller.request.FxRequest;
import com.app.fx.controller.response.FXResponse;
import com.app.fx.entities.ExchangeRatesMappingEntity;
import com.app.fx.repository.ExchangeRatesMappingEntityRepository;
import com.app.fx.services.impl.FxServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.validation.constraints.AssertTrue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.app.fx.util.FxDataUtils.getFxRateList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader= AnnotationConfigContextLoader.class)
public class FxServiceTest {


    @Autowired
    FxService fxService;


    @MockBean
    ExchangeRatesMappingEntityRepository repository;


    @Test
    public void fxRate() {

        List<ExchangeRatesMappingEntity>  mappingList=getFxRateList();
        Mockito.when(repository.findAll()).thenReturn(mappingList);
        List<FXResponse>  fxRateList=fxService.getAllFxRates();
        Assert.assertTrue("Should be equal to"+mappingList.size(), fxRateList.size()==mappingList.size());

    }

    @Test
    public void fxRates() {
        List<ExchangeRatesMappingEntity>  mappingList=getFxRateList();
        Mockito.when(repository.findByBaseCurrencyAndTargetCurrency(Mockito.anyString(),Mockito.anyString())).thenReturn(mappingList.get(0));

        FxRequest request= new FxRequest();
        request.setBaseCurrency("USD");
        request.setTargetCurrency("SGD");
        request.setBaseAmount(new BigDecimal(1.30));
        FXResponse  fxRate=fxService.getFxRates(request);
        Assert.assertTrue("Fx Amount should not be empty", fxRate.getExchangeAmount()!=null);


    }

    @org.springframework.context.annotation.Configuration
    public static class ContextConfiguration {

        @Bean
        public FxService getFxServiceImpl() {
            return new FxServiceImpl();
        }
    }
}
