package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.GatewayItemResponse;
import com.paydock.javasdk.Models.GatewayItemsResponse;
import com.paydock.javasdk.Models.GatewayRequest;
import com.paydock.javasdk.Models.GatewayResponse;
import com.paydock.javasdk.Models.GatewayUpdateRequest;

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
    String PublicKey = "8b2dad5fcf18f6f504685a46af0df82216781f3b";

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, SecretKey, PublicKey);
    }

    private GatewayResponse addGateway() throws Exception {
        GatewayRequest gateway = new GatewayRequest();
            gateway.type = "Brain";
            gateway.name = "BraintreeTesting";
            gateway.merchant = "r7pcwvkbkgjfzk99";
            gateway.username = "n8nktcb42fy8ttgt";
            gateway.password = "c865e194d750148b93284c0c026e5f2a";
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
        request._id = gateway.resource.data._id;
        request.name = "BraintreeTesting2";
        GatewayItemResponse result = new Gateways().update(request);
        Assert.assertTrue(result.get_IsSuccess());

    }

    @Test
    public void delete() throws Exception {
        GatewayResponse Gateway = addGateway();
        GatewayItemResponse delete = new Gateways().delete(Gateway.resource.data._id);
        Assert.assertTrue(delete.get_IsSuccess());
    }

}