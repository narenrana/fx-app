package com.app.fx.scheduler;


import com.app.fx.entities.ExchangeRatesMappingEntity;
import com.app.fx.repository.ExchangeRatesMappingEntityRepository;
import com.app.fx.utils.ExchangeCurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@EnableAsync
@Configuration
@EnableScheduling
@Slf4j
public class CurrencyExchangeSync {

    @Autowired
    private ExchangeRatesMappingEntityRepository exchangeRatesMappingEntityRepository;

    @Async
    @Scheduled(fixedRate = 10000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {

       System.out.println("Loading Fx data");

        final Iterable<ExchangeRatesMappingEntity> fxMappingList= exchangeRatesMappingEntityRepository.findAll();

        ExchangeCurrency.loadFxRates(list->{
            synchronized (list) {
                list.clear();
                fxMappingList.forEach(list::add);
                log.debug("Sync fx rates. Record loaded - {} , time - {}", list.size(), new Date().toString());
            }
        });

    }
}
