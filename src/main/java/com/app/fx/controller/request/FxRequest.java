package com.app.fx.controller.request;

import com.app.fx.validator.ValidLength;
import javax.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Request Object
 */
@Data
public class FxRequest {

    @ValidLength
    private String  baseCurrency;

    @ValidLength
    private String  targetCurrency;

    @Positive
    private BigDecimal baseAmount;

}
