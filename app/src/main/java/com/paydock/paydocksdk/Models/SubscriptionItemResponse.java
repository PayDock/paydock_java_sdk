
package com.paydock.paydocksdk.Models;

import java.math.BigDecimal;
import java.util.Date;
import com.paydock.paydocksdk.Models.Response;

public class SubscriptionItemResponse  extends Response 
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

        private String user_id;
        public String get_user_id() {
            return user_id;
        }
        public void set_user_id(String value) {
            user_id = value;
        }

        private String company_id;
        public String get_company_id() {
            return company_id;
        }
        public void set_company_id(String value) {
            company_id = value;
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

        private Payment_Source payment_source;
        public Payment_Source get_payment_source() {
            return payment_source;
        }
        public void set_payment_source(Payment_Source value) {
            payment_source = value;
        }
    }

    public static class Payment_Source   
    {
        private String gateway_name;
        public String get_gateway_name() {
            return gateway_name;
        }
        public void set_gateway_name(String value) {
            gateway_name = value;
        }

        private String gateway_type;
        public String get_gateway_type() {
            return gateway_type;
        }
        public void set_gateway_type(String value) {
            gateway_type = value;
        }

        private String gateway_mode;
        public String get_gateway_mode() {
            return gateway_mode;
        }
        public void set_gateway_mode(String value) {
            gateway_mode = value;
        }

        private String address_line1;
        public String get_address_line1() {
            return address_line1;
        }
        public void set_address_line1(String value) {
            address_line1 = value;
        }

        private String address_line2;
        public String get_address_line2() {
            return address_line2;
        }
        public void set_address_line2(String value) {
            address_line2 = value;
        }

        private String address_city;
        public String get_address_city() {
            return address_city;
        }
        public void set_address_city(String value) {
            address_city = value;
        }

        private String address_state;
        public String get_address_state() {
            return address_state;
        }
        public void set_address_state(String value) {
            address_state = value;
        }

        private String address_country;
        public String get_address_country() {
            return address_country;
        }
        public void set_address_country(String value) {
            address_country = value;
        }

        private String address_postcode;
        public String get_address_postcode() {
            return address_postcode;
        }
        public void set_address_postcode(String value) {
            address_postcode = value;
        }

        private String gateway_id;
        public String get_gateway_id() {
            return gateway_id;
        }
        public void set_gateway_id(String value) {
            gateway_id = value;
        }

        private String card_scheme;
        public String get_card_scheme() {
            return card_scheme;
        }
        public void set_card_scheme(String value) {
            card_scheme = value;
        }

        private String card_number_last4;
        public String get_card_number_last4() {
            return card_number_last4;
        }
        public void set_card_number_last4(String value) {
            card_number_last4 = value;
        }

        private String card_name;
        public String get_card_name() {
            return card_name;
        }
        public void set_card_name(String value) {
            card_name = value;
        }

        private String expire_year;
        public String get_expire_year() {
            return expire_year;
        }
        public void set_expire_year(String value) {
            expire_year = value;
        }

        private String expire_month;
        public String get_expire_month() {
            return expire_month;
        }
        public void set_expire_month(String value) {
            expire_month = value;
        }

        private String vault_token;
        public String get_vault_token() {
            return vault_token;
        }
        public void set_vault_token(String value) {
            vault_token = value;
        }

        private String account_name;
        public String get_account_name() {
            return account_name;
        }
        public void set_account_name(String value) {
            account_name = value;
        }

        private int account_bsb;
        public int get_account_bsb() {
            return account_bsb;
        }
        public void set_account_bsb(int value) {
            account_bsb = value;
        }

        private String account_number;
        public String get_account_number() {
            return account_number;
        }
        public void set_account_number(String value) {
            account_number = value;
        }

        private String ref_token;
        public String get_ref_token() {
            return ref_token;
        }
        public void set_ref_token(String value) {
            ref_token = value;
        }

        private String status;
        public String get_status() {
            return status;
        }
        public void set_status(String value) {
            status = value;
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

        private String _id;
        public String get_id() {
            return _id;
        }
        public void set_id(String value) {
            _id = value;
        }

        private String type;
        public String get_type() {
            return type;
        }
        public void set_type(String value) {
            type = value;
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


