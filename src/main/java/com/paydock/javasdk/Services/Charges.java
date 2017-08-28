
package com.paydock.javasdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.javasdk.Tools.UrlExtensionMethods;
import com.paydock.javasdk.Models.ChargeItemsResponse;
import com.paydock.javasdk.Models.ChargeRefundResponse;
import com.paydock.javasdk.Models.ChargeRequest;
import com.paydock.javasdk.Models.ChargeResponse;
import com.paydock.javasdk.Tools.HttpMethod;
import com.paydock.javasdk.Tools.IServiceHelper;
import com.paydock.javasdk.Tools.ServiceHelper;
import com.paydock.javasdk.Models.ChargeItemResponse;
import com.paydock.javasdk.Models.ChargeSearchRequest;

import java.math.BigDecimal;
import java.net.URLEncoder;

import static com.paydock.javasdk.Tools.UrlExtensionMethods.appendParameter;

/**
* Provides abstraction over the /charges endpoint for the API
*/
public class Charges  implements ICharges
{
    protected IServiceHelper _serviceHelper;// = new IServiceHelper();

    public Charges() throws Exception {
        _serviceHelper = new ServiceHelper();
    }


    public Charges(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }


    public ChargeResponse add(ChargeRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("charges", HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeResponse.class);
    }

    public ChargeItemsResponse get() throws Exception {
        String responseJson = _serviceHelper.callPaydock("charges", HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeItemsResponse.class);
    }

    public ChargeItemsResponse get(ChargeSearchRequest request) throws Exception {
        String url = "charges/";
        url = UrlExtensionMethods.appendParameter(url, "skip", request.skip);
        url = UrlExtensionMethods.appendParameter(url, "limit", request.limit);
        url = UrlExtensionMethods.appendParameter(url, "subscription_id", request.subscription_id);
        url = UrlExtensionMethods.appendParameter(url, "gateway_id", request.gateway_id);
        url = UrlExtensionMethods.appendParameter(url, "company_id", request.company_id);
        url = UrlExtensionMethods.appendParameter(url, "created_at.from", request.created_at_from);
        url = UrlExtensionMethods.appendParameter(url, "created_at.to", request.created_at_to);
        url = UrlExtensionMethods.appendParameter(url, "search", request.search);
        url = UrlExtensionMethods.appendParameter(url, "status", request.status);
        url = UrlExtensionMethods.appendParameter(url, "archived", request.archived);
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeItemsResponse.class);
    }

    public ChargeItemResponse get(String chargeId) throws Exception {
        URLEncoder.encode(chargeId, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("charges/" + chargeId, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeItemResponse.class);
    }

    public ChargeRefundResponse refund(String chargeId, BigDecimal amount) throws Exception {
        URLEncoder.encode(chargeId, "UTF-8");
        String json = String.format("{\"amount\" : \"%s\"}", amount);
        String responseJson = _serviceHelper.callPaydock("charges/" + chargeId + "/refunds", HttpMethod.POST, json, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeRefundResponse.class);
    }


    public ChargeRefundResponse archive(String chargeId) throws Exception {
        URLEncoder.encode(chargeId, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("charges/" + chargeId, HttpMethod.DELETE, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeRefundResponse.class);
    }

}


