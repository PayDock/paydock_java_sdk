package com.paydock.javasdk.Models;

import java.math.BigDecimal;
import java.util.Date;

public class WebhookCardExpiration extends Response {

    public String event;
    public Data data;

    public static class Data
    {
        public String _id;
        public Date created_at = null;
        public Date updated_at = null;
        public String company_id;
        public String user_id;
        public String default_source;
        public String first_name;
        public String last_name;
        public String email;
        public Statistics statistics;
        public Payment_Source payment_source;
    }

    public static class Statistics
    {
        public BigDecimal total_collected_amount;
        public int successful_transactions;
        public Currency currency;
    }

    public static class Currency
    {
        public AUD AUD;
    }

    public static class AUD
    {
        public BigDecimal total_amount;
        public int count;
    }

    public static class Payment_Source
    {
        public String _id;
        public Date created_at = null;
        public Date updated_at = null;
        public String vault_token;
        public String ref_token;
        public String status;
        public String type;
        public String card_name;
        public String card_number_last4;
        public String card_scheme;
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
        public String gateway_name;
        public String gateway_type;
    }

}
