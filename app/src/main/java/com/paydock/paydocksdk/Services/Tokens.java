//
// Translated by CS2J (http://www.cs2j.com): 7/06/2017 10:15:14 PM
//

package com.paydock.paydocksdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.paydocksdk.Models.SubscriptionResponse;
import com.paydock.paydocksdk.Models.TokenRequest;
import com.paydock.paydocksdk.Models.TokenResponse;
import com.paydock.paydocksdk.Services.Config;
import com.paydock.paydocksdk.Tools.HttpMethod;
import com.paydock.paydocksdk.Tools.IServiceHelper;
import com.paydock.paydocksdk.Tools.ServiceHelper;

import java.net.URLEncoder;

public class Tokens   
{
    protected IServiceHelper _serviceHelper;// = new IServiceHelper();
    /**
    * Service locator style constructor
    */
    public Tokens() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    /**
    * Dependency injection constructor to enable testing
    */
    public Tokens(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    /**
    * Creates a one-time token on Paydock
    * 
    *  @param request payment data to create the token
    *  @return One-Time token
    */
    public TokenResponse create(TokenRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("payment_sources/tokens?public_key=" + URLEncoder.encode(Config.getPublicKey(), "UTF-8"), HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        TokenResponse response = gson.fromJson(responseJson, TokenResponse.class);
        return response;
    }

}


