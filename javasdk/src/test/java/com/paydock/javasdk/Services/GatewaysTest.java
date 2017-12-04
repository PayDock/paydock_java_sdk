package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.GatewayData;
import com.paydock.javasdk.Models.GatewayItemResponse;
import com.paydock.javasdk.Models.GatewayItemsResponse;
import com.paydock.javasdk.Models.GatewayRequest;
import com.paydock.javasdk.Models.GatewayResponse;
import com.paydock.javasdk.Models.GatewayUpdateRequest;
import com.paydock.javasdk.PayDock;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GatewaysTest {

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, PayDock.SecretKey, PayDock.PublicKey);
    }

    private GatewayResponse addGateway() throws Exception {
        GatewayRequest gateway = new GatewayRequest();
            gateway.type = PayDock.GatewayType;
            gateway.name = PayDock.GatewayName;
            gateway.merchant = PayDock.GatewayMerchant;
            gateway.username = PayDock.GatewayUsername;
            gateway.password = PayDock.GatewayPassword;
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
        GatewayItemResponse result = new Gateways().get(PayDock.GatewayId);
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

    @After
    public void cleanup() throws Exception {
        GatewayItemsResponse Gateway = new Gateways().get();
        GatewayData[] GatewayData = Gateway.resource.data;
        for (int i = 0; i < Gateway.resource.count; i++) {
            if (GatewayData[i].name.contains("BraintreeTesting"))
                new Gateways().delete(GatewayData[i]._id);
        }
        Assert.assertTrue(true);
    }

}