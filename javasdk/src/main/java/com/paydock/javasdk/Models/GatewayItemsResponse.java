package com.paydock.javasdk.Models;

public class GatewayItemsResponse  extends Response
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public GatewayData[] data;
        public int count;
        public int limit;
        public int skip;
    }

}


