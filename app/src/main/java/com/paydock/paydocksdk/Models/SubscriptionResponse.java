
package com.paydock.paydocksdk.Models;

import java.math.BigDecimal;
import java.util.Date;
import com.paydock.paydocksdk.Models.Response;

public class SubscriptionResponse  extends Response 
{
    private Resource resource;
    public Resource get_resource() {
        return resource;
    }
    public void set_resource(Resource value) {
        resource = value;
    }

    public static class Resource   
    {
        private String type;
        public String get_type() {
            return type;
        }
        public void set_type(String value) {
            type = value;
        }

        private Data data;
        public Data get_data() {
            return data;
        }
        public void set_data(Data value) {
            data = value;
        }
    }

    public static class Data   
    {
        private int __v;
        public int get__v() {
            return __v;
        }
        public void set__v(int value) {
            __v = value;
        }

        private Date created_at;
        public Date get_created_at() {
            return created_at;
        }
        public void set_created_at(Date value) {
            created_at = value;
        }

        private Date updated_at;
        public Date get_updated_at() {
            return updated_at;
        }
        public void set_updated_at(Date value) {
            updated_at = value;
        }

        private BigDecimal amount;
        public BigDecimal get_amount() {
            return amount;
        }
        public void set_amount(BigDecimal value) {
            amount = value;
        }

        private String description;
        public String get_description() {
            return description;
        }
        public void set_description(String value) {
            description = value;
        }

        private String reference;
        public String get_reference() {
            return reference;
        }
        public void set_reference(String value) {
            reference = value;
        }

        private String status;
        public String get_status() {
            return status;
        }
        public void set_status(String value) {
            status = value;
        }

        private String _id;
        public String get_id() {
            return _id;
        }
        public void set_id(String value) {
            _id = value;
        }

        private boolean archived;
        public boolean get_archived() {
            return archived;
        }
        public void set_archived(boolean value) {
            archived = value;
        }

        private _Service _service;
        public _Service get__service() {
            return _service;
        }
        public void set__service(_Service value) {
            _service = value;
        }

        private Customer customer;
        public Customer get_customer() {
            return customer;
        }
        public void set_customer(Customer value) {
            customer = value;
        }

        private Statistics statistics;
        public Statistics get_statistics() {
            return statistics;
        }
        public void set_statistics(Statistics value) {
            statistics = value;
        }

        private Schedule schedule;
        public Schedule get_schedule() {
            return schedule;
        }
        public void set_schedule(Schedule value) {
            schedule = value;
        }

        private String currency;
        public String get_currency() {
            return currency;
        }
        public void set_currency(String value) {
            currency = value;
        }
    
    }

    public static class _Service   
    {
        private String customer_default_gateway_id;
        public String get_customer_default_gateway_id() {
            return customer_default_gateway_id;
        }
        public void set_customer_default_gateway_id(String value) {
            customer_default_gateway_id = value;
        }

        private String tags;
        public String get_tags() {
            return tags;
        }
        public void set_tags(String value) {
            tags = value;
        }
    }

    public static class Customer   
    {
        private String customer_id;
        public String get_customer_id() {
            return customer_id;
        }
        public void set_customer_id(String value) {
            customer_id = value;
        }

        private String first_name;
        public String get_first_name() {
            return first_name;
        }
        public void set_first_name(String value) {
            first_name = value;
        }

        private String last_name;
        public String get_last_name() {
            return last_name;
        }
        public void set_last_name(String value) {
            last_name = value;
        }

        private String email;
        public String get_email() {
            return email;
        }
        public void set_email(String value) {
            email = value;
        }

        private String reference;
        public String get_reference() {
            return reference;
        }
        public void set_reference(String value) {
            reference = value;
        }
    
    }

    public static class Statistics   
    {
        private BigDecimal total_collected_amount;
        public BigDecimal get_total_collected_amount() {
            return total_collected_amount;
        }
        public void set_total_collected_amount(BigDecimal value) {
            total_collected_amount = value;
        }

        private int successful_transactions;
        public int get_successful_transactions() {
            return successful_transactions;
        }
        public void set_successful_transactions(int value) {
            successful_transactions = value;
        }
    
    }

    public static class Schedule   
    {
        private String interval;
        public String get_interval() {
            return interval;
        }
        public void set_interval(String value) {
            interval = value;
        }

        private Date start_date;
        public Date get_start_date() {
            return start_date;
        }
        public void set_start_date(Date value) {
            start_date = value;
        }

        private Date end_date;
        public Date get_end_date() {
            return end_date;
        }
        public void set_end_date(Date value) {
            end_date = value;
        }

        private Date next_assessment;
        public Date get_next_assessment() {
            return next_assessment;
        }
        public void set_next_assessment(Date value) {
            next_assessment = value;
        }

        private Date first_assessment;
        public Date get_first_assessment() {
            return first_assessment;
        }
        public void set_first_assessment(Date value) {
            first_assessment = value;
        }

        private String status;
        public String get_status() {
            return status;
        }
        public void set_status(String value) {
            status = value;
        }

        private boolean locked;
        public boolean get_locked() {
            return locked;
        }
        public void set_locked(boolean value) {
            locked = value;
        }

        private int completed_count;
        public int get_completed_count() {
            return completed_count;
        }
        public void set_completed_count(int value) {
            completed_count = value;
        }

        private int retry_count;
        public int get_retry_count() {
            return retry_count;
        }
        public void set_retry_count(int value) {
            retry_count = value;
        }

        private int frequency;
        public int get_frequency() {
            return frequency;
        }
        public void set_frequency(int value) {
            frequency = value;
        }
    }

}


