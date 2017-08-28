
package com.paydock.javasdk.Models;

public class CustomerPaymentSourceSearchResponse extends Response
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public Data[] data;
        public int count;
        public int limit;
        public int skip;
    }

    public static class Data   
    {
        public String _id;
        public String card_number_last4;
        public String card_scheme;
        public String account_name;
        public String account_number;
        public String type;
        public String gateway_id;
        public String customer_id;
        public Boolean primary;
        public String customer_reference;
    }
}


