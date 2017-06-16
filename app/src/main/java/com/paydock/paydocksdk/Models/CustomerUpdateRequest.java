
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.PaymentSource;

public class CustomerUpdateRequest   
{
    private String customer_id;
    public String get_customer_id() {
        return customer_id;
    }
    public void set_customer_id(String value) {
        customer_id = value;
    }

    private String token;
    public String get_token() {
        return token;
    }
    public void set_token(String value) {
        token = value;
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

    private String reference;
    public String get_reference() {
        return reference;
    }
    public void set_reference(String value) {
        reference = value;
    }

    private String default_source;
    public String get_default_source() {
        return default_source;
    }
    public void set_default_source(String value) {
        default_source = value;
    }

    private PaymentSource payment_source;
    public PaymentSource get_payment_source() {
        return payment_source;
    }
    public void set_payment_source(PaymentSource value) {
        payment_source = value;
    }
}


