package com.app.fx.controller;

import com.app.fx.controller.request.FxRequest;
import com.app.fx.controller.response.FXResponse;
import com.app.fx.services.FxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FXController {
    @Autowired
    private FxService fxService;

    /**
     * API to get Fx rates
     * Sample Request payload
     {
      "baseCurrency": "USD",
      "targetCurrency":"SGD",
      "baseAmount": "10.788"
     }
     * Sample Response payload
     {
     "baseCurrency": "USD",
     "targetCurrency":"SGD",
     "baseAmount": "10.788",
     "exchangeRate":"",
     "exchangeAmount":"",
     }
     * @return
     */
    @PostMapping("/fx-rate")
    public FXResponse getFxRates(@Valid @RequestBody FxRequest request) {

        return fxService.getFxRates(request);

    }

    /**
     * API to get all Fx Rates
     * Sample Response payload
     [{
     "baseCurrency": "USD",
     "targetCurrency":"SGD",
     "baseAmount": "10.788",
     "exchangeRate":"",
     "exchangeAmount":"",
     }]
     * @return
     */
    @GetMapping("/fx-rates")
    public List<FXResponse> getAllRates() {

        return fxService.getAllFxRates();

    }

}
