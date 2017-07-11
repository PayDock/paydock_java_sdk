package com.paydock.paydocksdk.Models;

import java.math.BigDecimal;
import java.util.Date;

public class ChargeResponse  extends Response
{
    public Resource resource;

    public static class Resource
    {
        public String type;
        public Data data;
    }

    public static class Data
    {
        public String external_id;
        public int __v;
        public String _id;
        public BigDecimal amount;
        public String company_id;
        public Date created_at = null;
        public String currency;
        public String reference;
        public Date updated_at = null;
        public String user_id;
        public Transaction[] transactions = new Transaction[]{};
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
        public String type;
        public String card_name;
        public String card_number_last4;
        public int expire_month;
        public int expire_year;
        public String account_bank_name;
        public String account_name;
        public String account_number;
        public String account_bsb;
        public String account_routing;
        public String account_type;
        public String account_holder_type;
        public String address_postcode;
        public String gateway_id;
        public String card_scheme;
        public String gateway_name;
        public String gateway_type;
    }

    public static class Transaction
    {
        public String _id;
        public BigDecimal amount;
        public Date created_at = null;
        public String currency;
        public String status;
        public String type;
    }
}
