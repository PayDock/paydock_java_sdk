
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.Response;

import java.math.BigDecimal;
import java.util.Date;

public class ChargeRefundResponse  extends Response 
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
        private int v;
        public int get_v() {
            return v;
        }
        public void set_v(int value) {
            v = value;
        }
        
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

        private Date created_at = null; //new Date();
        public Date get_created_at() {
            return created_at;
        }
        public void set_created_at(Date value) {
            created_at = value;
        }

        private String currency;
        public String get_currency() {
            return currency;
        }
        public void set_currency(String value) {
            currency = value;
        }

        private String external_id;
        public String get_external_id() {
            return external_id;
        }
        public void set_external_id(String value) {
            external_id = value;
        }

        private Date updated_at = null; //new Date();
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

        private Transaction[] transactions = new Transaction[]{};
        public Transaction[] get_transactions() {
            return transactions;
        }
        public void set_transactions(Transaction[] value) {
            transactions = value;
        }

        private boolean one_off;
        public boolean get_one_off() {
            return one_off;
        }
        public void set_one_off(boolean value) {
            one_off = value;
        }

        private Customer customer;
        public Customer get_customer() {
            return customer;
        }
        public void set_customer(Customer value) {
            customer = value;
        }

        private String status;
        public String get_status() {
            return status;
        }
        public void set_status(String value) {
            status = value;
        }
    }

    public static class Customer   
    {
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
        private String card_name;
        public String get_card_name() {
            return card_name;
        }
        public void set_card_name(String value) {
            card_name = value;
        }

        private String card_number_last4;
        public String get_card_number_last4() {
            return card_number_last4;
        }
        public void set_card_number_last4(String value) {
            card_number_last4 = value;
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

        private String account_bank_name;
        public String get_account_bank_name() {
            return account_bank_name;
        }
        public void set_account_bank_name(String value) {
            account_bank_name = value;
        }

        private String account_name;
        public String get_account_name() {
            return account_name;
        }
        public void set_account_name(String value) {
            account_name = value;
        }

        private String account_number;
        public String get_account_number() {
            return account_number;
        }
        public void set_account_number(String value) {
            account_number = value;
        }

        private String account_bsb;
        public String get_account_bsb() {
            return account_bsb;
        }
        public void set_account_bsb(String value) {
            account_bsb = value;
        }

        private String account_routing;
        public String get_account_routing() {
            return account_routing;
        }
        public void set_account_routing(String value) {
            account_routing = value;
        }

        private String account_type;
        public String get_account_type() {
            return account_type;
        }
        public void set_account_type(String value) {
            account_type = value;
        }

        private String account_holder_type;
        public String get_account_holder_type() {
            return account_holder_type;
        }
        public void set_account_holder_type(String value) {
            account_holder_type = value;
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

        private String address_postcode;
        public String get_address_postcode() {
            return address_postcode;
        }
        public void set_address_postcode(String value) {
            address_postcode = value;
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
    }

    public static class Transaction   
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

        private Date created_at = null; //new Date();
        public Date get_created_at() {
            return created_at;
        }
        public void set_created_at(Date value) {
            created_at = value;
        }

        private String currency;
        public String get_currency() {
            return currency;
        }
        public void set_currency(String value) {
            currency = value;
        }

        private String status;
        public String get_status() {
            return status;
        }
        public void set_status(String value) {
            status = value;
        }

        private String type;
        public String get_type() {
            return type;
        }
        public void set_type(String value) {
            type = value;
        }

        private Date pended_at = null; //new Date();
        public Date get_pended_at() {
            return pended_at;
        }
        public void set_pended_at(Date value) {
            pended_at = value;
        }
    }
}


