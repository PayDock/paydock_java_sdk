package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.ExternalCheckoutRequest;
import com.paydock.javasdk.Models.ExternalCheckoutResponse;

public interface IExternalCheckout {

    ExternalCheckoutResponse create(ExternalCheckoutRequest request) throws Exception;

}
