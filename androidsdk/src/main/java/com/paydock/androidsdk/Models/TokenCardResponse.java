package com.paydock.androidsdk.Models;

import com.paydock.javasdk.Models.Response;

public class TokenCardResponse extends Response
{
    public String type;
    public String data;
    public String card_name;
    public String card_number_last4;
    public String expiry_month;
    public String expiry_year;
    public String account_bank_name;
    public String account_name;
    public String account_number;
    public String account_bsb;
    public String account_routing;
    public String account_type;
    public String account_holder_type;
    public String address_postcode;
    public String gateway_id;
    public String card_scheme;
    public String gateway_name;
    public String gateway_type;
}
