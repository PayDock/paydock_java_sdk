
package com.paydock.javasdk.Models;


import java.math.BigDecimal;

public class ExternalCheckoutRequestAfterPay extends ExternalCheckoutRequestBase
{
    public Meta meta;

    public static class Meta {
        public BigDecimal amount;
        public String currency;
        public Items[] items = new Items[]{};
        public String email;
        public String phone;
        public String first_name;
        public String last_name;
        public String address_line1;
        public String address_line2;
        public String address_city;
        public String address_state;
        public String address_country;
        public String address_postcode;
    }

    public static class Items {
        public String name;
        public String sku;
        public Integer quantity;
        public Price price = new Price();
    }

    public static class Price {
        public BigDecimal amount;
        public String currency;
    }

}
