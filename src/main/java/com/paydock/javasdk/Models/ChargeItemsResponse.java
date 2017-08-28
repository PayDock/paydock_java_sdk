
package com.paydock.javasdk.Models;

import java.math.BigDecimal;
import java.util.Date;

public class ChargeItemsResponse  extends Response
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
        public BigDecimal amount;
        public Date created_at = null;
        public String currency;
        public String description;
        public String external_id;
        public String reference;
        public Date updated_at = null;
        public boolean one_off;
        public boolean archived;
        public Customer customer;
        public String status;
    }

    public static class Customer   
    {
        public String first_name;
        public String last_name;
        public String email;
        public String reference;
        public Payment_Source payment_source;
    }

    public static class Payment_Source   
    {
        public String card_name;
        public String card_number_last4;
        public String expire_month;
        public String expire_year;
        public String account_bank_name;
        public String account_name;
        public String account_number;
        public String account_bsb;
        public String account_routing;
        public String account_type;
        public String account_holder_type;
        public String address_line1;
        public String address_line2;
        public String address_city;
        public String address_postcode;
        public String address_state;
        public String address_country;
        public String gateway_id;
        public String card_scheme;
        public String gateway_name;
        public String gateway_type;
    }
}


