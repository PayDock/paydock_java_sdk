
package com.paydock.javasdk.Models;


import java.math.BigDecimal;

public class ExternalCheckoutRequestZipMoney extends ExternalCheckoutRequestBase
{
    public String redirect_url;
    public Meta meta;

    public static class Meta {
        public String first_name;
        public String last_name;
        public String phone;
        public boolean tokenize = true;
        public String email;
        public String gender;
        public String date_of_birth;
        public Charge charge = new Charge();
        public Statistics statistics = new Statistics();
    }

    public static class Charge {
        public BigDecimal amount;
        public String currency;
        public Items[] items = new Items[]{};
        public ShippingAddress shipping_address = new ShippingAddress();
        public BillingAddress billing_address = new BillingAddress();

    }

    public static class ShippingAddress {
        public String first_name;
        public String last_name;
        public String line1;
        public String line2;
        public String city;
        public String state;
        public String country;
        public String postcode;
    }

    public static class BillingAddress {
        public String first_name;
        public String last_name;
        public String line1;
        public String line2;
        public String city;
        public String state;
        public String country;
        public String postcode;
    }

    public static class Items {
        public String name;
        public String amount;
        public Integer quantity;
        public String type;
        public String reference;
        public String item_uri;
        public String image_url;
    }

    public static class Statistics {
        public String account_created;
        public String sales_total_number;
        public String sales_total_amount;
        public String sales_avg_value;
        public String sales_max_value;
        public String refunds_total_amount;
        public String previous_chargeback;
        public String currency;
        public String last_login;
    }

}

