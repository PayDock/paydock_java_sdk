package com.paydock.javasdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.javasdk.Models.ExternalCheckoutRequest;
import com.paydock.javasdk.Models.ExternalCheckoutResponse;
import com.paydock.javasdk.Tools.HttpMethod;
import com.paydock.javasdk.Tools.IServiceHelper;
import com.paydock.javasdk.Tools.ServiceHelper;


public class ExternalCheckout implements IExternalCheckout {

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
