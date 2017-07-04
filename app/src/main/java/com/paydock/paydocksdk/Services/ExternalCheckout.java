package com.paydock.paydocksdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.paydocksdk.Models.ExternalCheckoutRequest;
import com.paydock.paydocksdk.Models.ExternalCheckoutResponse;
import com.paydock.paydocksdk.Tools.HttpMethod;
import com.paydock.paydocksdk.Tools.IServiceHelper;
import com.paydock.paydocksdk.Tools.ServiceHelper;


public class ExternalCheckout {

    protected IServiceHelper _serviceHelper;

    public ExternalCheckout() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    public ExternalCheckout(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    public ExternalCheckoutResponse create(ExternalCheckoutRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("payment_sources/external_checkout", HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ExternalCheckoutResponse.class);
    }
}
