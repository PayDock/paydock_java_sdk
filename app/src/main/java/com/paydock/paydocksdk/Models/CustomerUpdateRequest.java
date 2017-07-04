
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.PaymentSource;

public class CustomerUpdateRequest   
{
    public String customer_id;
    public String token;
    public String first_name;
    public String last_name;
    public String email;
    public String phone;
    public String reference;
    public String default_source;
    public PaymentSource payment_source;
}


