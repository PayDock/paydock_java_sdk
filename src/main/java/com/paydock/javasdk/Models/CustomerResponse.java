
package com.paydock.javasdk.Models;

import java.util.Date;

public class CustomerResponse  extends Response
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public Data data;
    }

    public static class Data   
    {
        public int __v;
        public Date created_at = null; // new Date();
        public Date updated_at = null; // new Date();
        public String status;
        public String default_source;
        public String first_name;
        public String last_name;
        public String email;
        public String phone;
        public String _id;
        public Payment_Sources[] payment_sources = new Payment_Sources[]{};
        public Statistics statistics;
        public _Service _service;
    }

    public static class Statistics   
    {
        public int total_collected_amount;
        public int successful_transactions;
    }

    public static class _Service   
    {
        public String default_gateway_id;
    }

    public static class Payment_Sources   
    {
        public Date updated_at = null;
        public String vault_token;
        public String address_line1;
        public String address_line2;
        public String address_city;
        public String address_state;
        public String address_country;
        public String address_postcode;
        public String gateway_id;
        public String card_name;
        public int expire_month;
        public int expire_year;
        public String card_number_last4;
        public String account_bsb;
        public String account_name;
        public String card_scheme;
        public String ref_token;
        public String status;
        public Date created_at = null; // new Date();
        public String _id;
        public String type;
    }

}


