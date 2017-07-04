
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.SubscriptionSchedule;

import java.math.BigDecimal;

public class SubscriptionUpdateRequest   
{
    public String _id;
    public BigDecimal amount;
    public String currency;
    public String reference;
    public String description;
    public String payment_source_id;
    public SubscriptionSchedule schedule;
}


