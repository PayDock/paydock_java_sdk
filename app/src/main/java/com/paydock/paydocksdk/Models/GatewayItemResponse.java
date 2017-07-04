package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.GatewayData;
import com.paydock.paydocksdk.Models.Response;

public class GatewayItemResponse  extends Response 
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public GatewayData data;
    }
}


