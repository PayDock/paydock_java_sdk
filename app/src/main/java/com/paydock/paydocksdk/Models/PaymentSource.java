
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.PaymentType;

public class PaymentSource   
{
    private String gateway_id;
    public String get_gateway_id() {
        return gateway_id;
    }
    public void set_gateway_id(String value) {
        gateway_id = value;
    }

    private PaymentType type = PaymentType.card;
    public PaymentType get_type() {
        return type;
    }
    public void set_type(PaymentType value) {
        type = value;
    }

    private String account_name;
    public String get_account_name() {
        return account_name;
    }
    public void set_account_name(String value) {
        account_name = value;
    }

    private String account_bsb;
    public String get_account_bsb() {
        return account_bsb;
    }
    public void set_account_bsb(String value) {
        account_bsb = value;
    }

    private String account_number;
    public String get_account_number() {
        return account_number;
    }
    public void set_account_number(String value) {
        account_number = value;
    }

    private String account_routing;
    public String get_account_routing() {
        return account_routing;
    }
    public void set_account_routing(String value) {
        account_routing = value;
    }

    private String account_holder_type;
    public String get_account_holder_type() {
        return account_holder_type;
    }
    public void set_account_holder_type(String value) {
        account_holder_type = value;
    }

    private String account_bank_name;
    public String get_account_bank_name() {
        return account_bank_name;
    }
    public void set_account_bank_name(String value) {
        account_bank_name = value;
    }

    private String card_name;
    public String get_card_name() {
        return card_name;
    }
    public void set_card_name(String value) {
        card_name = value;
    }

    private String card_number;
    public String get_card_number() {
        return card_number;
    }
    public void set_card_number(String value) {
        card_number = value;
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

    private String card_ccv;
    public String get_card_ccv() {
        return card_ccv;
    }
    public void set_card_ccv(String value) {
        card_ccv = value;
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

    private String state;
    public String get_state() {
        return state;
    }
    public void set_state(String value) {
        state = value;
    }

    private String address_country;
    public String get_address_country() {
        return address_country;
    }
    public void set_address_country(String value) {
        address_country = value;
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

}


