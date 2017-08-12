package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.ExternalCheckoutRequest;
import com.paydock.paydocksdk.Models.ExternalCheckoutResponse;

public interface IExternalCheckout {

    ExternalCheckoutResponse create(ExternalCheckoutRequest request) throws Exception;

}
