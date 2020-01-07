CREATE TABLE  `exchange_rates_mapping` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `baseCurrency` varchar(20),
    `targetCurrency` DECIMAL,
    `exchangeRate` DECIMAL,
    `created` timestamp default CURRENT_TIMESTAMP,
    `last_updated` timestamp default CURRENT_TIMESTAMP

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;


