package com.paydock.paydocksdk.Models;

import java.math.BigDecimal;
import java.util.HashMap;
import com.paydock.paydocksdk.Models.Customer;
import com.paydock.paydocksdk.Models.SubscriptionSchedule;

public class SubscriptionRequest   
{
    public BigDecimal amount;
    public String currency;
    public String reference;
    public String description;
    public String token;
    public String customer_id;
    public HashMap<String,String> meta;
    public Customer customer;
    public SubscriptionSchedule schedule;
    }


