package com.paydock.javasdk.Models;

import java.math.BigDecimal;
import java.util.Date;

public class WebhookSubscriptionTransaction extends Response {

    public String event;
    public Data data;

    public static class Data
    {
        public String _id;
        public Date created_at = null;
        public Date updated_at = null;
        public String company_id;
        public String user_id;
        public BigDecimal amount;
        public String currency;
        public String subscription_id;
        public int __v;
        public Transaction[] transactions;
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
        public String phone;
        public String reference;
        public Payment_Source payment_source;
    }

    public static class Payment_Source
    {
        public String type;
        public String card_name;
        public String card_number_last4;
        public String card_scheme;
        public String expire_month;
        public String expire_year;
        public String card_ccv;
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
    }

    public static class Transaction
    {
        public Date created_at = null;
        public Date pended_at = null;
        public BigDecimal amount;
        public String currency;
        public String _id;
        public String status;
        public String type;
    }

}


