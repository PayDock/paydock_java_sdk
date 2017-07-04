
package com.paydock.paydocksdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.paydocksdk.Models.*;
import com.paydock.paydocksdk.Tools.*;

import java.net.URLEncoder;

import static com.paydock.paydocksdk.Tools.UrlExtensionMethods.appendParameter;

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
        url = appendParameter(url, "skip", request.skip);
        url = appendParameter(url, "limit", request.limit);
        url = appendParameter(url, "search", request.search);
        url = appendParameter(url, "sortkey", request.sortkey);
        url = appendParameter(url, "sortdirection", request.sortdirection);
        url = appendParameter(url, "gateway_id", request.gateway_id);
        url = appendParameter(url, "archived", request.archived);
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, CustomerItemsResponse.class);
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


