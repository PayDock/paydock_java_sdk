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

    @Before
    public void init() throws Exception {
        String secretKey = "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9";
        String publicKey = "b2dad5fcf18f6f504685a46af0df82216781f3";
        Config.initialise(Environment.Sandbox, secretKey, publicKey);
    }


    @Test
    public void createLink() throws Exception {
        String paypalGatewayId = "58ede3577f8ce1233621d1bb";

        ExternalCheckoutRequest request = new ExternalCheckoutRequest();
        request.gateway_id = paypalGatewayId;
            request.mode = "test";
            request.success_redirect_url = "http://success.com";
            request.error_redirect_url = "http://error.com";

        ExternalCheckoutResponse response = new ExternalCheckout().create(request);
        Assert.assertTrue(response.get_IsSuccess());
    }

}