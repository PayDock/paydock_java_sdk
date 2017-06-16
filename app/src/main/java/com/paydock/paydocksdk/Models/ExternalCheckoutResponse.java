package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.Response;

public class ExternalCheckoutResponse  extends Response 
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

        private Data data;
        public Data get_data() {
            return data;
        }
        public void set_data(Data value) {
            data = value;
        }
    }

    public static class Data   
    {
        private String checkout_type;
        public String get_checkout_type() {
            return checkout_type;
        }
        public void set_checkout_type(String value) {
            checkout_type = value;
        }

        private String link;
        public String get_link() {
            return link;
        }
        public void set_link(String value) {
            link = value;
        }

        private String reference_id;
        public String get_reference_id() {
            return reference_id;
        }
        public void set_reference_id(String value) {
            reference_id = value;
        }

        private String mode;
        public String get_mode() {
            return mode;
        }
        public void set_mode(String value) {
            mode = value;
        }

        private String token;
        public String get_token() {
            return token;
        }
        public void set_token(String value) {
            token = value;
        }
    }

}


