package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.GatewayItemsResponse;
import com.paydock.javasdk.Models.GatewayUpdateRequest;
import com.paydock.javasdk.Models.GatewayItemResponse;
import com.paydock.javasdk.Models.GatewayRequest;
import com.paydock.javasdk.Models.GatewayResponse;


@SuppressWarnings("unused")
public interface IGateways
{
    GatewayResponse add(GatewayRequest request) throws Exception ;
    GatewayItemResponse delete(String GatewayId) throws Exception ;
    GatewayItemsResponse get() throws Exception ;
    GatewayItemResponse get(String GatewayId) throws Exception ;
    GatewayItemResponse update(GatewayUpdateRequest request) throws Exception ;
}
