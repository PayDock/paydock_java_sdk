package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.TokenRequest;
import com.paydock.javasdk.Models.TokenResponse;
import com.paydock.javasdk.Services.Config;
import com.paydock.javasdk.Services.Environment;
import com.paydock.javasdk.Services.Tokens;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TokensTest {

    String SecretKey = "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9";
    String GatewayId = "58b60d8a6da7e425d6e4f6c7";
    String PaypalGatewayId = "58ede3577f8ce1233621d1bb";
    String PublicKey = "8b2dad5fcf18f6f504685a46af0df82216781f3b";

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, SecretKey, PublicKey);
    }

    private TokenResponse createToken() throws Exception {
        TokenRequest tokenRequest = new TokenRequest() ;
            tokenRequest.gateway_id = GatewayId;
            tokenRequest.card_name = "Test Name";
            tokenRequest.card_number = "4111111111111111";
            tokenRequest.expire_month = "10";
            tokenRequest.expire_year = "2020";
            tokenRequest.card_ccv = "123";
        return new Tokens().create(tokenRequest);
    }


    @Test
    public void create() throws Exception {
        TokenResponse token = createToken();
        Assert.assertTrue(token.get_IsSuccess());
    }



}