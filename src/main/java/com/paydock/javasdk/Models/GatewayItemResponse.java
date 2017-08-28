package com.paydock.javasdk.Models;

public class GatewayItemResponse  extends Response
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public GatewayData data;
    }
}


