package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.ExternalCheckoutRequest;
import com.paydock.javasdk.Models.ExternalCheckoutResponse;
import com.paydock.javasdk.PayDock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExternalCheckoutTest {

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, PayDock.SecretKey, PayDock.PublicKey);
    }


    @Test
    public void createLink() throws Exception {

        ExternalCheckoutRequest request = new ExternalCheckoutRequest();
        request.gateway_id = PayDock.PaypalGatewayId;
            request.mode = "test";
            request.success_redirect_url = "http://success.com";
            request.error_redirect_url = "http://error.com";

        ExternalCheckoutResponse response = new ExternalCheckout().create(request);
        Assert.assertTrue(response.get_IsSuccess());
    }

}