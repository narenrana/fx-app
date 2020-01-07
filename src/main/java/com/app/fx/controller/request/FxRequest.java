package com.app.fx.controller.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Request Object
 */
@Data
public class FxRequest {

    private String  baseCurrency;
    private String  targetCurrency;
    private BigDecimal baseAmount;

}
