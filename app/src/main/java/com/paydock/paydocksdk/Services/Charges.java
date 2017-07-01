
package com.paydock.paydocksdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.paydocksdk.Models.ChargeItemResponse;
import com.paydock.paydocksdk.Models.ChargeItemsResponse;
import com.paydock.paydocksdk.Models.ChargeRefundResponse;
import com.paydock.paydocksdk.Models.ChargeRequest;
import com.paydock.paydocksdk.Models.ChargeResponse;
import com.paydock.paydocksdk.Models.ChargeSearchRequest;
import com.paydock.paydocksdk.Tools.HttpMethod;
import com.paydock.paydocksdk.Tools.IServiceHelper;
import com.paydock.paydocksdk.Tools.ServiceHelper;

import java.math.BigDecimal;
import java.net.URLEncoder;

import static com.paydock.paydocksdk.Tools.UrlExtensionMethods.appendParameter;

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
        String responseJson = _serviceHelper.callPaydock("charges", HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeResponse.class);
    }

    public ChargeItemsResponse get() throws Exception {
        String responseJson = _serviceHelper.callPaydock("charges", HttpMethod.GET, "");
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeItemsResponse.class);
    }

    public ChargeItemsResponse get(ChargeSearchRequest request) throws Exception {
        String url = "charges/";
        url = appendParameter(url, "skip", request.get_skip());
        url = appendParameter(url, "limit", request.get_limit());
        url = appendParameter(url, "subscription_id", request.get_subscription_id());
        url = appendParameter(url, "gateway_id", request.get_gateway_id());
        url = appendParameter(url, "company_id", request.get_company_id());
        url = appendParameter(url, "created_at.from", request.get_created_at_from());
        url = appendParameter(url, "created_at.to", request.get_created_at_to());
        url = appendParameter(url, "search", request.get_search());
        url = appendParameter(url, "status", request.get_status());
        url = appendParameter(url, "archived", request.get_archived());
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "");
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeItemsResponse.class);
    }

    public ChargeItemResponse get(String chargeId) throws Exception {
        URLEncoder.encode(chargeId, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("charges/" + chargeId, HttpMethod.GET, "");
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeItemResponse.class);
    }

    public ChargeRefundResponse refund(String chargeId, BigDecimal amount) throws Exception {
        URLEncoder.encode(chargeId, "UTF-8");
        String json = String.format("{\"amount\" : \"%s\"}", amount);
        String responseJson = _serviceHelper.callPaydock("charges/" + chargeId + "/refunds", HttpMethod.POST, json);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeRefundResponse.class);
    }


    public ChargeRefundResponse archive(String chargeId) throws Exception {
        URLEncoder.encode(chargeId, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("charges/" + chargeId, HttpMethod.DELETE, "");
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, ChargeRefundResponse.class);
    }

}


