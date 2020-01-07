CREATE TABLE  `exchange_rates_mapping` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `base_currency` varchar(3),
    `target_currency` varchar(3),
    `exchange_rate` DECIMAL,
    `created` timestamp default CURRENT_TIMESTAMP,
    `last_updated` timestamp default CURRENT_TIMESTAMP

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;


