
package com.paydock.paydocksdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.paydocksdk.Models.TokenRequest;
import com.paydock.paydocksdk.Models.TokenResponse;
import com.paydock.paydocksdk.Tools.HttpMethod;
import com.paydock.paydocksdk.Tools.IServiceHelper;
import com.paydock.paydocksdk.Tools.ServiceHelper;

import java.net.URLEncoder;

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
        String responseJson = _serviceHelper.callPaydock("payment_sources/tokens?public_key=" + URLEncoder.encode(Config.getPublicKey(), "UTF-8"), HttpMethod.POST, requestData, true);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, TokenResponse.class);
    }
}


