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
    /**
    * Service locator style constructor
    */
    public Subscriptions() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    /**
    * Dependency injection constructor to enable testing
    */
    public Subscriptions(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    /**
    * Creates a subscription
    * 
    *  @param request Subscription data
    *  @return created subscription
    */
    public SubscriptionResponse add(SubscriptionRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("subscriptions", HttpMethod.POST, requestData);
        SubscriptionResponse response = new Gson().fromJson(responseJson, SubscriptionResponse.class);
        return response;
    }

    /**
    * Updates a subscription
    * 
    *  @param request Subscription data
    *  @return updated subscription
    */
    public SubscriptionResponse update(SubscriptionUpdateRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("subscriptions/" + request.get_id(), HttpMethod.POST, requestData);
        SubscriptionResponse response = new Gson().fromJson(responseJson, SubscriptionResponse.class);
        return response;
    }

    /**
    * Retrieve all subscriptions, limited to 1000
    * 
    *  @return Subscription items
    */
    public SubscriptionItemsResponse get() throws Exception {
        String responseJson = _serviceHelper.callPaydock("subscriptions", HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        SubscriptionItemsResponse response = gson.fromJson(responseJson, SubscriptionItemsResponse.class);
        return response;
    }


    /**
    * Retrieve filtered list of subscriptions, limited to 1000
    * 
    *  @param //request search paramters for the subscriptions
    *  @return list of subscriptions
    */
    public SubscriptionItemsResponse get(SubscriptionSearchRequest request) throws Exception {
        String url = "subscriptions/";
        url = appendParameter(url, "skip", request.get_skip());
        url = appendParameter(url, "limit", request.get_limit());
        url = appendParameter(url, "search", request.get_search());
        url = appendParameter(url, "sortkey", request.get_sortkey());
        url = appendParameter(url, "sortdirection", request.get_sortdirection());
        url = appendParameter(url, "customer_id", request.get_customer_id());
        url = appendParameter(url, "gateway_id", request.get_gateway_id());
        url = appendParameter(url, "status", request.get_status());
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        SubscriptionItemsResponse response = gson.fromJson(responseJson, SubscriptionItemsResponse.class);
        return response;
    }

    /**
    * Retrieve a single subscription
    * 
    *  @param //request id of subscription to return
    *  @return subscription information
    */
    public SubscriptionItemResponse get(String subscriptionId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("subscriptions/" + subscriptionId, HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        SubscriptionItemResponse response = gson.fromJson(responseJson, SubscriptionItemResponse.class);
        return response;
    }

    /**
    * Delete a subscription
    * 
    *  @param subscriptionId id of the subscription
    *  @return information on the subscription
    */
    public SubscriptionItemResponse delete(String subscriptionId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("subscriptions/" + subscriptionId, HttpMethod.DELETE, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        SubscriptionItemResponse response = gson.fromJson(responseJson, SubscriptionItemResponse.class);
        return response;
    }

}


