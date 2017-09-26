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