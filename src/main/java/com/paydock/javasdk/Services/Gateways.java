package com.paydock.javasdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.javasdk.Models.GatewayUpdateRequest;
import com.paydock.javasdk.Tools.HttpMethod;
import com.paydock.javasdk.Tools.ServiceHelper;
import com.paydock.javasdk.Models.GatewayItemResponse;
import com.paydock.javasdk.Models.GatewayItemsResponse;
import com.paydock.javasdk.Models.GatewayRequest;
import com.paydock.javasdk.Models.GatewayResponse;
import com.paydock.javasdk.Tools.IServiceHelper;

import java.net.URLEncoder;



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
