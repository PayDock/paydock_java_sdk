package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.ExternalCheckoutRequest;
import com.paydock.javasdk.Models.ExternalCheckoutRequestAfterPay;
import com.paydock.javasdk.Models.ExternalCheckoutRequestZipMoney;
import com.paydock.javasdk.Models.ExternalCheckoutResponse;
import com.paydock.javasdk.PayDock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

@RunWith(JUnit4.class)
public class ExternalCheckoutTest {

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, PayDock.SecretKey, PayDock.PublicKey);
    }


    @Test
    public void createPayPalLink() throws Exception {
        ExternalCheckoutRequest request = new ExternalCheckoutRequest();
        request.gateway_id = PayDock.PaypalGatewayId;
        request.mode = "test";
        request.success_redirect_url = "http://success.com";
        request.error_redirect_url = "http://error.com";
        ExternalCheckoutResponse response = new ExternalCheckout().create(request);
        Assert.assertTrue(response.get_IsSuccess());
    }

    @Test
    public void createAfterPayLink() throws Exception {
        ExternalCheckoutRequestAfterPay request = new ExternalCheckoutRequestAfterPay();
        request.gateway_id = PayDock.AfterPayGatewayId;
        request.mode = "test";
        request.success_redirect_url = "http://success.com";
        request.error_redirect_url = "http://error.com";
        ExternalCheckoutRequestAfterPay.Meta meta = new ExternalCheckoutRequestAfterPay.Meta();
            meta.amount = new BigDecimal(20);
            meta.currency = "AUD";
            ExternalCheckoutRequestAfterPay.Items[] items = new ExternalCheckoutRequestAfterPay.Items[2]; //create new array
            ExternalCheckoutRequestAfterPay.Items items1 = new ExternalCheckoutRequestAfterPay.Items(); //set up first transfer in array
                items1.name = "widget1";
                items1.sku = "1234122346";
                items1.quantity = 1;
                items1.price.amount = new BigDecimal(20);
                items1.price.currency = "AUD";
            ExternalCheckoutRequestAfterPay.Items items2 = new ExternalCheckoutRequestAfterPay.Items(); //set up first transfer in array
                items2.name = "widget2";
                items2.sku = "1234122345";
                items2.quantity = 1;
                items2.price.amount = new BigDecimal(10);
                items2.price.currency = "AUD";
            items[0] = items1; //add the transfers to the array
            items[1] = items2;
            meta.items = items;
            meta.email = "test@test.com";
            meta.first_name = "testFirstName";
            meta.last_name = "testLastName";
            meta.address_line1 = "AddrLine1";
            meta.address_line2 = "AddrLine2";
            meta.address_city = "AddrCity";
            meta.address_state = "NSW";
            meta.address_postcode = "1234";
            meta.address_country = "AddrCountry";
            meta.phone = "040000000";
        request.meta = meta;

        ExternalCheckoutResponse response = new ExternalCheckout().create(request);
        Assert.assertTrue(response.get_IsSuccess());
    }

    @Test
    public void createZipMoneyLink() throws Exception {
        ExternalCheckoutRequestZipMoney request = new ExternalCheckoutRequestZipMoney();
        request.gateway_id = PayDock.ZipMoneyGatewayId;
        request.mode = "test";
        request.redirect_url = "https://success.com";
        ExternalCheckoutRequestZipMoney.Meta meta = new ExternalCheckoutRequestZipMoney.Meta();
            meta.first_name = "testFirstName";
            meta.last_name = "testLastName";
            meta.email = "test@test.com";
            meta.tokenize = true;
            meta.gender = "male";
            meta.date_of_birth = "01/01/1980";
            ExternalCheckoutRequestZipMoney.Charge charge = new ExternalCheckoutRequestZipMoney.Charge();
            charge.amount = new BigDecimal(6);
            charge.currency = "AUD";
            ExternalCheckoutRequestZipMoney.ShippingAddress shipping_address = new ExternalCheckoutRequestZipMoney.ShippingAddress();
                shipping_address.first_name = "Shipping FName";
                shipping_address.last_name = "Shipping LName";
                shipping_address.line1 = "Addr Line 1";
                shipping_address.line2 = "Addr Line 2";
                shipping_address.city = "Addr City";
                shipping_address.state = "NSW";
                shipping_address.postcode = "1234";
                shipping_address.country = "AU";
            charge.shipping_address = shipping_address;
            ExternalCheckoutRequestZipMoney.BillingAddress billing_address = new ExternalCheckoutRequestZipMoney.BillingAddress();
                billing_address.first_name = "Billing FName";
                billing_address.last_name = "Billing LName";
                billing_address.line1 = "Addr Line1";
                billing_address.line2 = "Addr Line2";
                billing_address.city = "Addr City";
                billing_address.state = "NSW";
                billing_address.postcode = "1234";
                billing_address.country = "AU";
            charge.billing_address = billing_address;
            ExternalCheckoutRequestZipMoney.Items[] items = new ExternalCheckoutRequestZipMoney.Items[2]; //create new array
            ExternalCheckoutRequestZipMoney.Items items1 = new ExternalCheckoutRequestZipMoney.Items(); //set up first transfer in array
                items1.name = "Shoes";
                items1.amount = "2";
                items1.quantity = 1;
                items1.reference = "sds";
            ExternalCheckoutRequestZipMoney.Items items2 = new ExternalCheckoutRequestZipMoney.Items(); //set up first transfer in array
                items2.name = "Shoes2";
                items2.amount = "4";
                items2.quantity = 1;
                items2.reference = "sds1";
            items[0] = items1; //add the transfers to the array
            items[1] = items2;
            charge.items = items;
        meta.charge = charge;
        ExternalCheckoutRequestZipMoney.Statistics statistics = new ExternalCheckoutRequestZipMoney.Statistics();
            statistics.account_created = "2017-05-05";
            statistics.sales_total_number = "5";
            statistics.sales_total_amount = "4";
            statistics.sales_avg_value = "45";
            statistics.sales_max_value = "400";
            statistics.refunds_total_amount = "1";
            statistics.previous_chargeback = "false";
            statistics.currency = "AUD";
            statistics.last_login = "2017-06-01";
        meta.statistics = statistics;
        request.meta = meta;
        ExternalCheckoutResponse response = new ExternalCheckout().create(request);
        Assert.assertTrue(response.get_IsSuccess());
    }

}