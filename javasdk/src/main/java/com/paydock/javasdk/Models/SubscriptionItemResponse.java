
package com.paydock.javasdk.Models;

import java.math.BigDecimal;
import java.util.Date;

public class SubscriptionItemResponse  extends Response 
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public Data data;
    }

    public static class Data   
    {
        public Date created_at = null;
        public Date updated_at = null;
        public String user_id;
        public String company_id;
        public BigDecimal amount;
        public String description;
        public String reference;
        public String status;
        public String _id;
        public boolean archived;
        public Customer customer;
        public Statistics statistics;
        public Schedule schedule;
        public String currency;
    }

    public static class Customer   
    {
        public String customer_id;
        public String first_name;
        public String last_name;
        public String email;
        public String reference;
        public Payment_Source payment_source;
    }

    public static class Payment_Source   
    {
        public String gateway_name;
        public String gateway_type;
        public String gateway_mode;
        public String address_line1;
        public String address_line2;
        public String address_city;
        public String address_state;
        public String address_country;
        public String address_postcode;
        public String gateway_id;
        public String card_scheme;
        public String card_number_last4;
        public String card_name;
        public String expire_year;
        public String expire_month;
        public String vault_token;
        public String account_name;
        public int account_bsb;
        public String account_number;
        public String ref_token;
        public String status;
        public Date created_at;
        public Date updated_at;
        public String _id;
        public String type;
    }

    public static class Statistics   
    {
        public BigDecimal total_collected_amount;
        public int successful_transactions;
    }

    public static class Schedule   
    {
        public String interval;
        public Date start_date = null;
        public Date end_date = null;
        public Date next_assessment = null;
        public Date first_assessment = null;
        public String status;
        public boolean locked;
        public int completed_count;
        public int retry_count;
        public int frequency;
    }

}


