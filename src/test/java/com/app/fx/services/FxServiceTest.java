package com.app.fx.services;

import com.app.fx.repository.ExchangeRatesMappingEntityRepository;
import com.app.fx.services.impl.FxServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader= AnnotationConfigContextLoader.class)
public class FxServiceTest {


    @Mock
    ExchangeRatesMappingEntityRepository exchangeRatesMappingEntityRepository;


    @Test
    public void fxRate() {


    }

    @org.springframework.context.annotation.Configuration
    public static class ContextConfiguration {


        @Bean
        public FxService getBlockFriendsService() {
            return new FxServiceImpl();
        }
    }
}
