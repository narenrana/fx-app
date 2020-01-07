package com.app.fx.services;

import com.app.fx.controller.request.FxRequest;
import com.app.fx.controller.response.FXResponse;

public interface FxService {

    FXResponse getFxRates(FxRequest fxRequest);
}
