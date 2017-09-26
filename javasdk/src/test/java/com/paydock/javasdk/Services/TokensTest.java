package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.TokenRequest;
import com.paydock.javasdk.Models.TokenResponse;
import com.paydock.javasdk.PayDock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TokensTest {

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, PayDock.SecretKey, PayDock.PublicKey);
    }

    private TokenResponse createToken() throws Exception {
        TokenRequest tokenRequest = new TokenRequest() ;
            tokenRequest.gateway_id = PayDock.GatewayId;
            tokenRequest.email = "testpin21_1@test.com";
            tokenRequest.card_name = "Test Name";
            tokenRequest.card_number = "5520000000000000";
            tokenRequest.expire_month = "05";
            tokenRequest.expire_year = "2018";
            tokenRequest.card_ccv = "123";
        return new Tokens().create(tokenRequest);
    }

    @Test
    public void create() throws Exception {
        TokenResponse token = createToken();
        Assert.assertTrue(token.get_IsSuccess());
    }

}