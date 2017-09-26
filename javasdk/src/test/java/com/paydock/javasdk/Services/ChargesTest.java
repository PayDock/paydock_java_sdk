package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.ChargeItemResponse;
import com.paydock.javasdk.Models.ChargeItemsResponse;
import com.paydock.javasdk.Models.ChargeRefundResponse;
import com.paydock.javasdk.Models.ChargeRequest;
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

    private ChargeResponse CreateBasicCharge(BigDecimal chargeAmount, String gatewayId, String customerEmail) throws Exception {
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

    private ChargeItemsResponse CreateSearchCharge(String gatewayId) throws Exception {
        ChargeSearchRequest request = new ChargeSearchRequest();
        request.gateway_id = gatewayId;
        return new Charges().get(request);
    }

    @Test
    public void add() throws Exception {
        ChargeResponse charge = CreateBasicCharge(new BigDecimal("8"), PayDock.GatewayId, "test@email.com");
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