package com.paydock.paydocksdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.paydocksdk.Models.GatewayItemResponse;
import com.paydock.paydocksdk.Models.GatewayItemsResponse;
import com.paydock.paydocksdk.Models.GatewayRequest;
import com.paydock.paydocksdk.Models.GatewayResponse;
import com.paydock.paydocksdk.Models.GatewayUpdateRequest;
import com.paydock.paydocksdk.Tools.HttpMethod;
import com.paydock.paydocksdk.Tools.IServiceHelper;
import com.paydock.paydocksdk.Tools.ServiceHelper;

import java.net.URLEncoder;


/**
 * Created by Mark on 17/06/2017.
 */

public class Gateways implements IGateways{

    protected IServiceHelper _serviceHelper;// = new IServiceHelper();
    /**
     * Service locator style constructor
     */
    public Gateways() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    /**
     * Dependency injection constructor to enable testing
     */
    public Gateways(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    /**
     * Add a charge
     *
     *  @param request Gateway data
     *  @return Gateway response
     */

    public GatewayResponse add(GatewayRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("gateways", HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        GatewayResponse response = gson.fromJson(responseJson, GatewayResponse.class);
        return response;
    }

    /**
     * Retrieve full list of Gateways, limited to 1000
     *
     *  @return List of Gateways
     */
    public GatewayItemsResponse get() throws Exception {
        String responseJson = _serviceHelper.callPaydock("gateways", HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        GatewayItemsResponse response = gson.fromJson(responseJson, GatewayItemsResponse.class);
        return response;
    }


    /**
     * Retrieve a single Gateway
     *
     *  @param gatewayId id of the Gateway to retreive
     *  @return Gateway data
     */
    public GatewayItemResponse get(String gatewayId) throws Exception {
        URLEncoder.encode(gatewayId, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("gateways/" + gatewayId, HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        GatewayItemResponse response = gson.fromJson(responseJson, GatewayItemResponse.class);
        return response;
    }

    /**
     * Update gateway
     *
     *  @param request of the Gateway to update
     *  @return information on the transaction
     */
    public GatewayItemResponse update(GatewayUpdateRequest request) throws Exception {
        String gatewayId = URLEncoder.encode(request.get_id(), "UTF-8");
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("gateways/" + gatewayId , HttpMethod.PUT, requestData);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        GatewayItemResponse response = gson.fromJson(responseJson, GatewayItemResponse.class);
        return response;
    }

    /**
     * Delete a gateway
     *
     *  @param gatewayId id of the Gateway to delete
     *  @return information on the transaction
     */
    public GatewayItemResponse delete(String gatewayId) throws Exception {
        URLEncoder.encode(gatewayId, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("gateways/" + gatewayId, HttpMethod.DELETE, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        GatewayItemResponse response = gson.fromJson(responseJson, GatewayItemResponse.class);
        return response;
    }
}
