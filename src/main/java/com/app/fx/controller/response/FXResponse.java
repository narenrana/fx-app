package com.app.fx.controller.response;
import lombok.Data;
import java.math.BigDecimal;

/**
 * Response Object
 */

@Data
public class FXResponse {
    private String  baseCurrency;
    private String  targetCurrency;
    private BigDecimal baseAmount;
    private BigDecimal  exchangeRate;
    private BigDecimal  exchangeAmount;
}
