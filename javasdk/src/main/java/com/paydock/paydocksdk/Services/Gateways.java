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

    protected IServiceHelper _serviceHelper;//

    public Gateways() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    public Gateways(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }


    public GatewayResponse add(GatewayRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("gateways", HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, GatewayResponse.class);
    }

    public GatewayItemsResponse get() throws Exception {
        String responseJson = _serviceHelper.callPaydock("gateways", HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, GatewayItemsResponse.class);
    }

    public GatewayItemResponse get(String gatewayId) throws Exception {
        URLEncoder.encode(gatewayId, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("gateways/" + gatewayId, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, GatewayItemResponse.class);
    }

    public GatewayItemResponse update(GatewayUpdateRequest request) throws Exception {
        String gatewayId = URLEncoder.encode(request._id, "UTF-8");
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("gateways/" + gatewayId , HttpMethod.PUT, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, GatewayItemResponse.class);
    }

    public GatewayItemResponse delete(String gatewayId) throws Exception {
        URLEncoder.encode(gatewayId, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("gateways/" + gatewayId, HttpMethod.DELETE, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, GatewayItemResponse.class);
    }
}
