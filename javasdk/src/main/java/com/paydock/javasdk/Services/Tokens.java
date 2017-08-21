
package com.paydock.javasdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.javasdk.Models.TokenRequest;
import com.paydock.javasdk.Models.TokenResponse;
import com.paydock.javasdk.Tools.HttpMethod;
import com.paydock.javasdk.Tools.IServiceHelper;
import com.paydock.javasdk.Tools.ServiceHelper;

public class Tokens implements ITokens
{
    protected IServiceHelper _serviceHelper;

    public Tokens() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    public Tokens(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    public TokenResponse create(TokenRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("payment_sources/tokens", HttpMethod.POST, requestData, true);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, TokenResponse.class);
    }
}


