package com.paydock.javasdk.Models;

import java.math.BigDecimal;
import java.util.Date;

public class SubscriptionItemsResponse  extends Response 
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public Datum[] data;
        public int count;
        public int limit;
        public int skip;
    }

    public static class Datum   
    {
        public String _id;
        public BigDecimal amount;
        public String company_id;
        public Date created_at = null;
        public String status;
        public Date updated_at = null;
        public String user_id;
        public boolean archived;
        public Customer customer;
        public Statistics statistics;
        public Schedule schedule;
        public String currency;
        public String gateway_type;
        public String gateway_name;
        public String gateway_mode;
    }

    public static class Customer   
    {
        public String customer_id;
        public String first_name;
        public String last_name;
        public String email;
        public String reference;
    }

    public static class Statistics   
    {
        public BigDecimal total_collected_amount;
        public int successful_transactions;
    }

    public static class Schedule   
    {
        public BigDecimal end_amount_total;
        public Date first_assessment = null;
        public String interval;
        public Date last_assessment = null;
        public Date next_assessment = null;
        public Date start_date = null;
        public Date end_date = null;
        public String status;
        public boolean locked;
        public int completed_count;
        public int retry_count;
        public int frequency;
    }

}


