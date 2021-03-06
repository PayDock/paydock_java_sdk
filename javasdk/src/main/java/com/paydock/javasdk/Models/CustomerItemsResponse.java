
package com.paydock.javasdk.Models;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerItemsResponse  extends Response 
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public Data[] data;
        public String query_token;
        public int count;
        public int limit;
        public int skip;
    }

    public static class Data   
    {
        public String _id;
        public Date created_at = null;
        public Date updated_at = null;
        public String status;
        public String _source_ip_address;
        public String default_source;
        public String company_id;
        public String user_id;
        public String first_name;
        public String last_name;
        public String email;
        public String phone;
        public Payment_Source[] payment_sources;
        public boolean archived;
        public Statistics statistics;
        public _Service _service;
    }

    public static class Statistics   
    {
        public BigDecimal total_collected_amount;
        public int successful_transactions;
    }

    public static class _Service
    {
        public String default_gateway_id;
    }

    public static class Payment_Source   
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
        public String card_scheme;
        public String account_name;
        public String account_number;
        public String account_bsb;
        public String account_routing;
        public String account_type;
        public String account_holder_type;
        public String account_bank_name;
        public String ref_token;
        public String status;
        public Date created_at = null;
        public String _id;
        public String type;
    }

}


