package com.paydock.javasdk.Models;

import java.math.BigDecimal;
import java.util.Date;

public class WebhookSubscriptionEvents extends Response {

    public String event;
    public Data data;

    public static class Data
    {
        public int __v;
        public Date created_at = null;
        public Date updated_at = null;
        public BigDecimal amount;
        public String payment_source_id;
        public String _source_ip_address;
        public String status;
        public String _id;
        public String user_id;
        public String company_id;
        public boolean archived;
        public _Service _service;
        public Customer customer;
        public Statistics statistics;
        public Schedule schedule;
        public String currency;
        public String gateway_name;
        public String gateway_type;
        public String gateway_mode;
    }

    public static class _Service
    {
        public String customer_default_gateway_id;
        public String tags;
        public String queue_id;
    }

    public static class Customer
    {
        public String customer_id;
        public String first_name;
        public String last_name;
        public String email;
        public String phone;
        public String reference;
        public boolean _check_expire_date;
    }

    public static class Statistics
    {
        public BigDecimal total_collected_amount;
        public int successful_transactions;
    }

    public static class Schedule
    {
        public BigDecimal end_amount_after;
        public BigDecimal end_amount_before;
        public BigDecimal end_amount_total;
        public Integer end_transactions;
        public String interval;
        public Date start_date;
        public Date end_date;
        public Date next_assessment;
        public Date next_assessment_planned;
        public Date first_assessment;
        public Date last_assessment;
        public String status;
        public boolean locked;
        public int completed_count;
        public int retry_count;
        public int frequency;
    }

}


