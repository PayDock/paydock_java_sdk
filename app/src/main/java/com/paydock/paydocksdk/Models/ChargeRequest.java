
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.Customer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ChargeRequest   
{
    private BigDecimal amount;
    public BigDecimal get_amount() {
        return amount;
    }
    public void set_amount(BigDecimal value) {
        amount = value;
    }

    private String currency;
    public String get_currency() {
        return currency;
    }
    public void set_currency(String value) {
        currency = value;
    }

    private String token;
    public String get_token() {
        return token;
    }
    public void set_token(String value) {
        token = value;
    }

    private String reference;
    public String get_reference() {
        return reference;
    }
    public void set_reference(String value) {
        reference = value;
    }

    private String description;
    public String get_description() {
        return description;
    }
    public void set_description(String value) {
        description = value;
    }

    private String customer_id;
    public String get_customer_id() {
        return customer_id;
    }
    public void set_customer_id(String value) {
        customer_id = value;
    }

    private Map<String, String> meta;
    public Map<String, String> get_meta() {
        return meta;
    }
    public void set_meta(Map<String, String> value) {
        meta = value;
    }

    private Customer customer;
    public Customer get_customer() {
        return customer;
    }
    public void set_customer(Customer value) {
        customer = value;
    }

}


