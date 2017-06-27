
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.Response;

import java.util.Date;

public class CustomerResponse  extends Response 
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
        public int get_v() {
            return __v;
        }
        public void set_v(int value) {
            __v = value;
        }

        private Date created_at = null; // new Date();
        public Date get_created_at() {
            return created_at;
        }
        public void set_created_at(Date value) {
            created_at = value;
        }

        private Date updated_at = null; // new Date();
        public Date get_updated_at() {
            return updated_at;
        }
        public void set_updated_at(Date value) {
            updated_at = value;
        }

        private String status;
        public String get_status() {
            return status;
        }
        public void set_status(String value) {
            status = value;
        }

        private String default_source;
        public String get_default_source() {
            return default_source;
        }
        public void set_default_source(String value) {
            default_source = value;
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

        private String phone;
        public String get_phone() {
            return phone;
        }
        public void set_phone(String value) {
            phone = value;
        }

        private String _id;
        public String get_id() {
            return _id;
        }
        public void set_id(String value) {
            _id = value;
        }

        private Payment_Sources[] payment_sources = new Payment_Sources[]{};
        public Payment_Sources[] get_payment_sources() {
            return payment_sources;
        }
        public void set_payment_sources(Payment_Sources[] value) {
            payment_sources = value;
        }

        private Statistics statistics;
        public Statistics get_statistics() {
            return statistics;
        }
        public void set_statistics(Statistics value) {
            statistics = value;
        }

        private _Service _service;
        public _Service get__service() {
            return _service;
        }
        public void set__service(_Service value) {
            _service = value;
        }
    }

    public static class Statistics   
    {
        private int total_collected_amount;
        public int get_total_collected_amount() {
            return total_collected_amount;
        }
        public void set_total_collected_amount(int value) {
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

    public static class _Service   
    {
        private String default_gateway_id;
        public String get_default_gateway_id() {
            return default_gateway_id;
        }
        public void set_default_gateway_id(String value) {
            default_gateway_id = value;
        }
    }

    public static class Payment_Sources   
    {
        private Date updated_at = null; // new Date();
        public Date get_updated_at() {
            return updated_at;
        }
        public void set_updated_at(Date value) {
            updated_at = value;
        }

        private String vault_token;
        public String get_vault_token() {
            return vault_token;
        }
        public void set_vault_token(String value) {
            vault_token = value;
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

        private String card_name;
        public String get_card_name() {
            return card_name;
        }
        public void set_card_name(String value) {
            card_name = value;
        }

        private int expire_month;
        public int get_expire_month() {
            return expire_month;
        }
        public void set_expire_month(int value) {
            expire_month = value;
        }

        private int expire_year;
        public int get_expire_year() {
            return expire_year;
        }
        public void set_expire_year(int value) {
            expire_year = value;
        }

        private String card_number_last4;
        public String get_card_number_last4() {
            return card_number_last4;
        }
        public void set_card_number_last4(String value) {
            card_number_last4 = value;
        }

        private String account_bsb;
        public String get_account_bsb() {
            return account_bsb;
        }
        public void set_account_bsb(String value) {
            account_bsb = value;
        }

        private String account_name;
        public String get_account_name() {
            return account_name;
        }
        public void set_account_name(String value) {
            account_name = value;
        }

        private String card_scheme;
        public String get_card_scheme() {
            return card_scheme;
        }
        public void set_card_scheme(String value) {
            card_scheme = value;
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

        private Date created_at = null; // new Date();
        public Date get_created_at() {
            return created_at;
        }
        public void set_created_at(Date value) {
            created_at = value;
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

}


