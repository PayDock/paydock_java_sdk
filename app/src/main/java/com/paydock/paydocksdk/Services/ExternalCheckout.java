package com.paydock.paydocksdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.paydocksdk.Models.CustomerRequest;
import com.paydock.paydocksdk.Models.CustomerResponse;
import com.paydock.paydocksdk.Models.ExternalCheckoutRequest;
import com.paydock.paydocksdk.Models.ExternalCheckoutResponse;
import com.paydock.paydocksdk.Tools.HttpMethod;
import com.paydock.paydocksdk.Tools.IServiceHelper;
import com.paydock.paydocksdk.Tools.ServiceHelper;

/**
 * Created by Mark on 17/06/2017.
 */

public class ExternalCheckout {

    protected IServiceHelper _serviceHelper;// = new IServiceHelper();
    /**
     * Service locator style constructor
     */
    public ExternalCheckout() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    /**
     * Dependency injection constructor to enable testing
     */
    public ExternalCheckout(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    /**
     *
     */
    public ExternalCheckoutResponse create(ExternalCheckoutRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("payment_sources/external_checkout", HttpMethod.POST, requestData);
        Gson gson = new Gson();
        ExternalCheckoutResponse response = gson.fromJson(responseJson, ExternalCheckoutResponse.class);
        return response;
    }

}
