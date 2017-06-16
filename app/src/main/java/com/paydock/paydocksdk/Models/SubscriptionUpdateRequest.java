
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.SubscriptionSchedule;

import java.math.BigDecimal;

public class SubscriptionUpdateRequest   
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

    private String currency;
    public String get_currency() {
        return currency;
    }
    public void set_currency(String value) {
        currency = value;
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

    private String payment_source_id;
    public String get_payment_source_id() {
        return payment_source_id;
    }
    public void set_payment_source_id(String value) {
        payment_source_id = value;
    }

    private SubscriptionSchedule schedule;
    public SubscriptionSchedule get_schedule() {
        return schedule;
    }
    public void set_schedule(SubscriptionSchedule value) {
        schedule = value;
    }
}


