package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.GatewayItemResponse;
import com.paydock.paydocksdk.Models.GatewayItemsResponse;
import com.paydock.paydocksdk.Models.GatewayRequest;
import com.paydock.paydocksdk.Models.GatewayResponse;
import com.paydock.paydocksdk.Models.GatewayUpdateRequest;
import com.paydock.paydocksdk.Models.PaymentSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GatewaysTest {

    String SecretKey = "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9";
    String GatewayId = "58b60d8a6da7e425d6e4f6c7";
    String PaypalGatewayId = "58ede3577f8ce1233621d1bb";
    String PublicKey = "b2dad5fcf18f6f504685a46af0df82216781f3";

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, SecretKey, PublicKey);
    }

    private GatewayResponse addGateway() throws Exception {
        GatewayRequest gateway = new GatewayRequest();
            gateway.set_type("Brain");
            gateway.set_name("BraintreeTesting");
            gateway.set_merchant("r7pcwvkbkgjfzk99");
            gateway.set_username("n8nktcb42fy8ttgt");
            gateway.set_password("c865e194d750148b93284c0c026e5f2a");
        return new Gateways().add(gateway);
    }


    @Test
    public void add() throws Exception {
        GatewayResponse gateway = addGateway();
        Assert.assertTrue(gateway.get_IsSuccess());
    }

    @Test
    public void get() throws Exception {
        GatewayItemsResponse result = new Gateways().get();
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void get1() throws Exception {
        GatewayItemResponse result = new Gateways().get(GatewayId);
        Assert.assertTrue(result.get_IsSuccess());
    }


    @Test
    public void update() throws Exception {
        GatewayResponse gateway = addGateway();
        GatewayUpdateRequest request = new GatewayUpdateRequest();
        request.set_id(gateway.get_resource().get_data().get_id());
        request.set_name("BraintreeTesting2");
        GatewayItemResponse result = new Gateways().update(request);
        Assert.assertTrue(result.get_IsSuccess());

    }

    @Test
    public void delete() throws Exception {
        GatewayResponse Gateway = addGateway();
        GatewayItemResponse delete = new Gateways().delete(Gateway.get_resource().get_data().get_id());
        Assert.assertTrue(delete.get_IsSuccess());
    }

}