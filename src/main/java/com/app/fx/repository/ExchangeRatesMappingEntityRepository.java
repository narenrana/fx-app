package com.app.fx.repository;
import com.app.fx.entities.ExchangeRatesMappingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRatesMappingEntityRepository  extends CrudRepository<ExchangeRatesMappingEntity, Long> {

    ExchangeRatesMappingEntity findByBaseCurrencyAAndTargetCurrency(String baseCurrency, String targetCurrency);
}