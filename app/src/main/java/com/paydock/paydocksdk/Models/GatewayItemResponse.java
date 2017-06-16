package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.GatewayData;
import com.paydock.paydocksdk.Models.Response;

public class GatewayItemResponse  extends Response 
{
    private Resource resource;
    public Resource get_resource() {
        return resource;
    }
    public void set_resource(Resource value) {
        resource = value;
    }

    public static class Resource   
    {
        private String type;
        public String get_type() {
            return type;
        }
        public void set_type(String value) {
            type = value;
        }

        private GatewayData data;
        public GatewayData get_data() {
            return data;
        }
        public void set_data(GatewayData value) {
            data = value;
        }
    }

}


