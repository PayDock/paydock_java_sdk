 package com.paydock.paydocksdk.Models;

 import com.paydock.paydocksdk.Models.Customer;

 import java.math.BigDecimal;
 import java.util.Map;

public class ChargeRequest
{
    public BigDecimal amount;
    public String currency;
    public String token;
    public String reference;
    public String description;
    public String customer_id;
    public Map<String, String> meta;
    public Customer customer;
}
