//
// Translated by CS2J (http://www.cs2j.com): 7/06/2017 10:15:14 PM
//

package com.paydock.paydocksdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.paydocksdk.Models.*;
import com.paydock.paydocksdk.Tools.*;

import static com.paydock.paydocksdk.Tools.UrlExtensionMethods.appendParameter;

public class Subscriptions   implements ISubscriptions
{
    protected IServiceHelper _serviceHelper;// = new IServiceHelper();

    public Subscriptions() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    public Subscriptions(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    public SubscriptionResponse add(SubscriptionRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("subscriptions", HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, SubscriptionResponse.class);
    }


    public SubscriptionResponse update(SubscriptionUpdateRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("subscriptions/" + request._id, HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, SubscriptionResponse.class);
    }


    public SubscriptionItemsResponse get() throws Exception {
        String responseJson = _serviceHelper.callPaydock("subscriptions", HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, SubscriptionItemsResponse.class);
    }

    public SubscriptionItemsResponse get(SubscriptionSearchRequest request) throws Exception {
        String url = "subscriptions/";
        url = appendParameter(url, "skip", request.skip);
        url = appendParameter(url, "limit", request.limit);
        url = appendParameter(url, "search", request.search);
        url = appendParameter(url, "sortkey", request.sortkey);
        url = appendParameter(url, "sortdirection", request.sortdirection);
        url = appendParameter(url, "customer_id", request.customer_id);
        url = appendParameter(url, "gateway_id", request.gateway_id);
        url = appendParameter(url, "status", request.status);
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, SubscriptionItemsResponse.class);
    }

    public SubscriptionItemResponse get(String subscriptionId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("subscriptions/" + subscriptionId, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, SubscriptionItemResponse.class);
    }

    public SubscriptionItemResponse delete(String subscriptionId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("subscriptions/" + subscriptionId, HttpMethod.DELETE, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, SubscriptionItemResponse.class);
    }
}


