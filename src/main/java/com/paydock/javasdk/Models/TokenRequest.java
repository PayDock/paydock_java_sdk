
package com.paydock.javasdk.Models;

public class TokenRequest
{
    public String gateway_id;
    public PaymentType type = PaymentType.card;
    public String card_name;
    public String card_number;
    public String expire_month;
    public String expire_year;
    public String card_ccv;
    public String account_name;
    public String account_bsb;
    public String account_number;
    public String account_routing;
    public String account_holder_type;
    public String account_bank_name;
    public String first_name;
    public String last_name;
    public String email;
    public String phone;
    public String address_line1;
    public String address_line2;
    public String address_city;
    public String address_state;
    public String address_country;
    public String address_postcode;
    public String checkout_token;
}


