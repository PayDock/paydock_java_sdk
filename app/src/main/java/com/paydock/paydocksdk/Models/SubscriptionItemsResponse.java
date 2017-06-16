package com.paydock.paydocksdk.Models;

import java.math.BigDecimal;
import java.util.Date;
import com.paydock.paydocksdk.Models.Response;

public class SubscriptionItemsResponse  extends Response 
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

        private Datum[] data;
        public Datum[] get_data() {
            return data;
        }
        public void set_data(Datum[] value) {
            data = value;
        }

        private int count;
        public int get_count() {
            return count;
        }
        public void set_count(int value) {
            count = value;
        }

        private int limit;
        public int get_limit() {
            return limit;
        }
        public void set_limit(int value) {
            limit = value;
        }

        private int skip;
        public int get_skip() {
            return skip;
        }
        public void set_skip(int value) {
            skip = value;
        }
    }

    public static class Datum   
    {
        private String _id;
        public String get_id() {
            return _id;
        }
        public void set_id(String value) {
            _id = value;
        }

        private BigDecimal amount;
        public BigDecimal get_amount() {
            return amount;
        }
        public void set_amount(BigDecimal value) {
            amount = value;
        }

        private String company_id;
        public String get_company_id() {
            return company_id;
        }
        public void set_company_id(String value) {
            company_id = value;
        }

        private Date created_at;
        public Date get_created_at() {
            return created_at;
        }
        public void set_created_at(Date value) {
            created_at = value;
        }

        private String status;
        public String get_status() {
            return status;
        }
        public void set_status(String value) {
            status = value;
        }

        private Date updated_at;
        public Date get_updated_at() {
            return updated_at;
        }
        public void set_updated_at(Date value) {
            updated_at = value;
        }

        private String user_id;
        public String get_user_id() {
            return user_id;
        }
        public void set_user_id(String value) {
            user_id = value;
        }

        private boolean archived;
        public boolean get_archived() {
            return archived;
        }
        public void set_archived(boolean value) {
            archived = value;
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

        private String gateway_type;
        public String get_gateway_type() {
            return gateway_type;
        }
        public void set_gateway_type(String value) {
            gateway_type = value;
        }

        private String gateway_name;
        public String get_gateway_name() {
            return gateway_name;
        }
        public void set_gateway_name(String value) {
            gateway_name = value;
        }

        private String gateway_mode;
        public String get_gateway_mode() {
            return gateway_mode;
        }
        public void set_gateway_mode(String value) {
            gateway_mode = value;
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
        private BigDecimal end_amount_total;
        public BigDecimal get_end_amount_total() {
            return end_amount_total;
        }
        public void set_end_amount_total(BigDecimal value) {
            end_amount_total = value;
        }

        private Date first_assessment;
        public Date get_first_assessment() {
            return first_assessment;
        }
        public void set_first_assessment(Date value) {
            first_assessment = value;
        }

        private String interval;
        public String get_interval() {
            return interval;
        }
        public void set_interval(String value) {
            interval = value;
        }

        private Date last_assessment;
        public Date get_last_assessment() {
            return last_assessment;
        }
        public void set_last_assessment(Date value) {
            last_assessment = value;
        }

        private Date next_assessment;
        public Date get_next_assessment() {
            return next_assessment;
        }
        public void set_next_assessment(Date value) {
            next_assessment = value;
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


