package com.app.fx.services;

import com.app.fx.controller.request.FxRequest;
import com.app.fx.controller.response.FXResponse;

import java.util.List;

public interface FxService {

    FXResponse getFxRates(FxRequest fxRequest);

    List<FXResponse> getAllFxRates();
}
