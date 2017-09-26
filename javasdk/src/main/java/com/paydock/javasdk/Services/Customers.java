
package com.paydock.javasdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.javasdk.Models.CustomerItemResponse;
import com.paydock.javasdk.Models.CustomerItemsResponse;
import com.paydock.javasdk.Models.CustomerPaymentSourceSearchRequest;
import com.paydock.javasdk.Models.CustomerPaymentSourceSearchResponse;
import com.paydock.javasdk.Models.CustomerRequest;
import com.paydock.javasdk.Models.CustomerResponse;
import com.paydock.javasdk.Models.CustomerSearchRequest;
import com.paydock.javasdk.Models.CustomerUpdateRequest;
import com.paydock.javasdk.Tools.HttpMethod;
import com.paydock.javasdk.Tools.IServiceHelper;
import com.paydock.javasdk.Tools.ServiceHelper;
import com.paydock.javasdk.Tools.UrlExtensionMethods;

import java.net.URLEncoder;

public class Customers  implements ICustomers
{
    protected IServiceHelper _serviceHelper;// = new IServiceHelper();

    public Customers() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    public Customers(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    public CustomerResponse add(CustomerRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("customers", HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, CustomerResponse.class);
    }

    public CustomerItemsResponse get() throws Exception {
        String responseJson = _serviceHelper.callPaydock("customers", HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, CustomerItemsResponse.class);
    }

    public CustomerItemsResponse get(CustomerSearchRequest request) throws Exception {
        String url = "customers/";
        url = UrlExtensionMethods.appendParameter(url, "skip", request.skip);
        url = UrlExtensionMethods.appendParameter(url, "limit", request.limit);
        url = UrlExtensionMethods.appendParameter(url, "search", request.search);
        url = UrlExtensionMethods.appendParameter(url, "sortkey", request.sortkey);
        url = UrlExtensionMethods.appendParameter(url, "sortdirection", request.sortdirection);
        url = UrlExtensionMethods.appendParameter(url, "gateway_id", request.gateway_id);
        url = UrlExtensionMethods.appendParameter(url, "payment_source_id", request.payment_source_id);
        url = UrlExtensionMethods.appendParameter(url, "id", request._id);
        url = UrlExtensionMethods.appendParameter(url, "gateway_id", request.gateway_id);
        url = UrlExtensionMethods.appendParameter(url, "reference", request.reference);
        url = UrlExtensionMethods.appendParameter(url, "archived", request.archived);
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, CustomerItemsResponse.class);
    }

    public CustomerPaymentSourceSearchResponse get(CustomerPaymentSourceSearchRequest request) throws Exception {
        String url = "customers/payment_sources";
        URLEncoder.encode(url, "UTF-8");
        url = UrlExtensionMethods.appendParameter(url, "query_token", request.query_token);
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "", true);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, CustomerPaymentSourceSearchResponse.class);
    }

    public String getQueryToken(String customerID) throws Exception {
        CustomerSearchRequest request = new CustomerSearchRequest();
        request._id = customerID;
        CustomerItemsResponse result = new Customers().get(request);
        return result.resource.query_token;
    }


    public CustomerItemResponse get(String customerId) throws Exception {
        URLEncoder.encode(customerId, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("customers/" + customerId, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, CustomerItemResponse.class);
    }

    public CustomerItemResponse update(CustomerUpdateRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("customers/" + request.customer_id, HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, CustomerItemResponse.class);
    }

    public CustomerItemResponse delete(String customerId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("customers/" + customerId, HttpMethod.DELETE, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, CustomerItemResponse.class);
    }
}


