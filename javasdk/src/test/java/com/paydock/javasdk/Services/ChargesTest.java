package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.ChargeItemResponse;
import com.paydock.javasdk.Models.ChargeItemsResponse;
import com.paydock.javasdk.Models.ChargeRefundResponse;
import com.paydock.javasdk.Models.ChargeRequest;
import com.paydock.javasdk.Models.ChargeRequestStripeConnect;
import com.paydock.javasdk.Models.ChargeResponse;
import com.paydock.javasdk.Models.ChargeSearchRequest;
import com.paydock.javasdk.Models.Customer;
import com.paydock.javasdk.Models.PaymentSource;
import com.paydock.javasdk.PayDock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

@SuppressWarnings("SameParameterValue")
@RunWith(JUnit4.class)
public class ChargesTest {

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, PayDock.SecretKey, PayDock.PublicKey);
    }

    private ChargeResponse CreateBasicCharge(BigDecimal chargeAmount, String gatewayId,
                                             String customerEmail) throws Exception {
        ChargeRequest charge = new ChargeRequest();
        charge.currency = "AUD";
        charge.description = "Test charge description";
        charge.amount = chargeAmount;
            Customer customer = new Customer();
            customer.first_name = "Justin";
            customer.last_name = "Timberlake";
            customer.email = customerEmail;
                PaymentSource payment_source = new PaymentSource();
                payment_source.gateway_id = gatewayId;
                payment_source.card_name = "Test Name";
                payment_source.card_number = "5520000000000000";
                payment_source.expire_month = "10";
                payment_source.expire_year = "2020";
                payment_source.card_ccv = "123";
            customer.payment_source = payment_source;
        charge.customer = customer;
        return new Charges().add(charge);
    }

    private ChargeResponse CreateStripeConnectCharge(BigDecimal chargeAmount, String gatewayId,
                                             String customerEmail) throws Exception {
        ChargeRequestStripeConnect charge = new ChargeRequestStripeConnect();
        charge.currency = "AUD";
        charge.description = "Test Stripe description";
        charge.amount = chargeAmount;
            Customer customer = new Customer();
            customer.first_name = "Justin";
            customer.last_name = "Timberlake";
            customer.email = customerEmail;
                PaymentSource payment_source = new PaymentSource();
                payment_source.gateway_id = gatewayId;
                payment_source.card_name = "Test Name";
                payment_source.card_number = "4242424242424242";
                payment_source.expire_month = "01";
                payment_source.expire_year = "2019";
                payment_source.card_ccv = "123";
            customer.payment_source = payment_source;
        charge.customer = customer;
        charge.meta.stripe_transfer_group = PayDock.StripeTransferGroup;

        ChargeRequestStripeConnect.Transfer[] stripe_transfer_array = new ChargeRequestStripeConnect.Transfer[2]; //create new array
        ChargeRequestStripeConnect.Transfer transfer1 = new ChargeRequestStripeConnect.Transfer(); //set up first transfer in array
            transfer1.amount = new BigDecimal(80);
            transfer1.currency = "AUD";
            transfer1.destination = PayDock.StripeDestinationAccount1;
        ChargeRequestStripeConnect.Transfer transfer2 = new ChargeRequestStripeConnect.Transfer(); //set up second transfer in array
            transfer2.amount = new BigDecimal(10);
            transfer2.currency = "AUD";
            transfer2.destination = PayDock.StripeDestinationAccount2;
        stripe_transfer_array[0] = transfer1; //add the transfers to the array
        stripe_transfer_array[1] = transfer2;

        charge.meta.stripe_transfer = stripe_transfer_array;
        return new Charges().add(charge);
    }

    private ChargeItemsResponse CreateSearchCharge(String gatewayId) throws Exception {
        ChargeSearchRequest request = new ChargeSearchRequest();
        request.gateway_id = gatewayId;
        return new Charges().get(request);
    }

    @Test
    public void add() throws Exception {
        ChargeResponse charge = CreateBasicCharge(new BigDecimal("7"), PayDock.GatewayId,
                "test@email.com");
        Assert.assertTrue(charge.get_IsSuccess());
    }

    @Test
    public void addStripeConnect() throws Exception {
        ChargeResponse charge = CreateStripeConnectCharge(new BigDecimal("100"), PayDock.StripeGatewayId,
                "test@email.com");
        Assert.assertTrue(charge.get_IsSuccess());
    }

    @Test
    public void get() throws Exception {
        ChargeItemsResponse result = new Charges().get();
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void get1() throws Exception {
        ChargeItemsResponse result = CreateSearchCharge(PayDock.GatewayId);
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void get2() throws Exception {
        ChargeResponse charge = CreateBasicCharge(new BigDecimal("9"), PayDock.GatewayId, "test@email.com");
        ChargeItemResponse result = new Charges().get(charge.resource.data._id);
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void refund() throws Exception {
        ChargeResponse charge = CreateBasicCharge(new BigDecimal("11"), PayDock.GatewayId, "test@email.com");
        ChargeRefundResponse refund = new Charges().refund(charge.resource.data._id, new BigDecimal("11"));
        Assert.assertTrue(refund.get_IsSuccess());

    }

    @Test
    public void archive() throws Exception {
        ChargeResponse charge = CreateBasicCharge(new BigDecimal("12"), PayDock.GatewayId, "test@email.com");
        ChargeRefundResponse refund = new Charges().archive(charge.resource.data._id);
        Assert.assertTrue(refund.get_IsSuccess());
    }

}