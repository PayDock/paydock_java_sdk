package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.ExternalCheckoutRequest;
import com.paydock.paydocksdk.Models.ExternalCheckoutResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExternalCheckoutTest {

    private String SecretKey = "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9";
    private String GatewayId = "58b60d8a6da7e425d6e4f6c7";
    private String PaypalGatewayId = "58ede3577f8ce1233621d1bb";
    private String PublicKey = "b2dad5fcf18f6f504685a46af0df82216781f3";

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, SecretKey, PublicKey);
    }


    @Test
    public void createLink() throws Exception {

        ExternalCheckoutRequest request = new ExternalCheckoutRequest();
            request.set_gateway_id(PaypalGatewayId);
            request.set_mode("test");
            request.set_success_redirect_url("http://success.com");
            request.set_error_redirect_url("http://error.com");

        ExternalCheckoutResponse response = new ExternalCheckout().create(request);
        Assert.assertTrue(response.get_IsSuccess());
    }

}