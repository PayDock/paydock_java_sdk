
package com.paydock.javasdk.Models;

import java.math.BigDecimal;
import java.util.Date;

public class SubscriptionResponse  extends Response 
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
        public Date created_at = null;
        public Date updated_at = null;
        public BigDecimal amount;
        public String description;
        public String reference;
        public String status;
        public String _id;
        public boolean archived;
        public _Service _service;
        public Customer customer;
        public Statistics statistics;
        public Schedule schedule;
        public String currency;
    }

    public static class _Service   
    {
        public String customer_default_gateway_id;
        public String tags;
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
        public String interval;
        public Date start_date;
        public Date end_date;
        public Date next_assessment;
        public Date first_assessment;
        public Date next_assessment_planned;
        public String status;
        public boolean locked;
        public int completed_count;
        public int retry_count;
        public int frequency;
    }

}


