 package com.paydock.javasdk.Models;

 import java.math.BigDecimal;

 abstract class ChargeRequestBase
 {
     public BigDecimal amount;
     public String currency;
     public String token;
     public String reference;
     public String description;
     public String customer_id;
     public String payment_source_id;
     public Customer customer;
 }
