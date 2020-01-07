package com.app.fx.model;

import lombok.Data;

@Data
public  abstract class Currency  implements TradingCurrency {
    private String id;
    private String name;
}
