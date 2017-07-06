
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.PaymentType;

public class PaymentSource   
{
    public String gateway_id;
    public PaymentType type = PaymentType.card;
    public String account_name;
    public String account_bsb;
    public String account_number;
    public String account_routing;
    public String account_holder_type;
    public String account_bank_name;
    public String card_name;
    public String card_number;
    public String expire_year;
    public String expire_month;
    public String card_ccv;
    public String address_line1;
    public String address_line2;
    public String state;
    public String address_country;
    public String address_city;
    public String address_postcode;
}


