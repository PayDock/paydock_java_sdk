
package com.paydock.javasdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.javasdk.Models.VaultItemResponse;
import com.paydock.javasdk.Models.VaultItemsResponse;
import com.paydock.javasdk.Models.VaultRequest;
import com.paydock.javasdk.Models.VaultResponse;
import com.paydock.javasdk.Tools.HttpMethod;
import com.paydock.javasdk.Tools.IServiceHelper;
import com.paydock.javasdk.Tools.ServiceHelper;

import java.net.URLEncoder;


public class Vault implements IVault
{
    protected IServiceHelper _serviceHelper;// = new IServiceHelper();

    public Vault() throws Exception {
        _serviceHelper = new ServiceHelper();
    }


    public Vault(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }


    public VaultResponse add(VaultRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("vault/payment_sources", HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, VaultResponse.class);
    }

    public VaultItemsResponse get() throws Exception {
        String responseJson = _serviceHelper.callPaydock("vault/payment_sources", HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, VaultItemsResponse.class);
    }

    public VaultItemResponse get(String vaultToken) throws Exception {
        URLEncoder.encode(vaultToken, "UTF-8");
        String responseJson = _serviceHelper.callPaydock("vault/payment_sources/" + vaultToken, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, VaultItemResponse.class);
    }

}


