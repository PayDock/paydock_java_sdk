
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
    /**
    * Service locator style constructor
    */
    public Customers() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    /**
    * Dependency injection constructor to enable testing
    */
    public Customers(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    /**
    * Adds a customer to Paydock
    * 
    *  @param request Stores the customer information to add
    *  @return details of the created customer
    */
    public CustomerResponse add(CustomerRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("customers", HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        CustomerResponse response = gson.fromJson(responseJson, CustomerResponse.class);
        return response;
    }

    /**
    * Retrieve full list of customers, limited to 1000
    * 
    *  @return list of customers
    */
    public CustomerItemsResponse get() throws Exception {
        String responseJson = _serviceHelper.callPaydock("customers", HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        CustomerItemsResponse response = gson.fromJson(responseJson, CustomerItemsResponse.class);
        return response;
    }

    /**
    * Retrieve filtered list of customers, limited to 1000
    * 
    *  @param request search paramters for the customers
    *  @return list of customers
    */
    public CustomerItemsResponse get(CustomerSearchRequest request) throws Exception {
        String url = "customers/";
        url = appendParameter(url, "skip", request.get_skip());
        url = appendParameter(url, "limit", request.get_limit());
        url = appendParameter(url, "search", request.get_search());
        url = appendParameter(url, "sortkey", request.get_sortkey());
        url = appendParameter(url, "sortdirection", request.get_sortdirection());
        url = appendParameter(url, "gateway_id", request.get_gateway_id());
        url = appendParameter(url, "archived", request.get_archived());
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        CustomerItemsResponse response = gson.fromJson(responseJson, CustomerItemsResponse.class);
        return response;
    }


    /**
    * Retrieve a single customer
    *
    *  @param //request id of customer to return
    *  @return customer information
    */
    public CustomerItemResponse get(String customerId) throws Exception {
        URLEncoder.encode(customerId, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("customers/" + customerId, HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        CustomerItemResponse response = gson.fromJson(responseJson, CustomerItemResponse.class);
        return response;
    }

    /**
    * Update customer details
    *
    *  @param request customers details to change
    *  @return customer information
    */
    public CustomerItemResponse update(CustomerUpdateRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("customers/" + request.get_customer_id(), HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        CustomerItemResponse response = gson.fromJson(responseJson, CustomerItemResponse.class);
        return response;
    }

    /**
    * Deletes a single customer
    * 
    *  @param customerId id of customer to delete
    *  @return customer information
    */
    public CustomerItemResponse delete(String customerId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("customers/" + customerId, HttpMethod.DELETE, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        CustomerItemResponse response = gson.fromJson(responseJson, CustomerItemResponse.class);
        return response;
    }

}


