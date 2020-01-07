package com.app.fx.controller;

import com.app.fx.controller.request.FxRequest;
import com.app.fx.controller.response.FXResponse;
import com.app.fx.services.FxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/friend")
public class FXController {
    @Autowired
    private FxService fxService;

    /**
     * API to create a friend connection between two email addresses.
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
    public FXResponse connectFriend(@Valid @RequestBody FxRequest request) {

        return fxService.getFxRates(request);

    }

}
