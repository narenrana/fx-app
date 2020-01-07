package com.app.fx.model;

import lombok.Data;

@Data
abstract class Currency  implements TradingCurrency {
    String id;
    String name;
}
