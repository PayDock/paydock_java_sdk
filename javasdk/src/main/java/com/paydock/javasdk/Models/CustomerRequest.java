
package com.paydock.javasdk.Models;

import java.util.Map;

public class CustomerRequest   
{
    public String token;
    public String first_name;
    public String last_name;
    public String email;
    public String phone;
    public String reference;
    public PaymentSource payment_source;
    public Map<String, String> meta;
}


