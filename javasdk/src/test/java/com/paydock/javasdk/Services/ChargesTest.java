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
import com.paydock.javasdk.Models.PaymentType;
import com.paydock.javasdk.PayDock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

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

    private ChargeResponse CreateBankCharge(BigDecimal chargeAmount, String gatewayId,
                                             String customerEmail) throws Exception {
        ChargeRequest charge = new ChargeRequest();
        charge.currency = "AUD";
        charge.description = "Test bank description";
        charge.amount = chargeAmount;
        Customer customer = new Customer();
            customer.first_name = "Justin";
            customer.last_name = "Timberlake";
            customer.email = customerEmail;
            PaymentSource payment_source = new PaymentSource();
                payment_source.gateway_id = gatewayId;
                payment_source.type = PaymentType.bsb;
                payment_source.account_name = "Mark Test";
                payment_source.account_number = "064000";
                payment_source.account_bsb = "064000";
                payment_source.account_holder_type = "personal";
                payment_source.account_bank_name = "Bank";
            customer.payment_source = payment_source;
        charge.customer = customer;
        return new Charges().add(charge);
    }

    private ChargeResponse CreateBasicChargeAuthorisation(BigDecimal chargeAmount, String gatewayId,
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
                payment_source.card_number = "4242424242424242";
                payment_source.expire_month = "10";
                payment_source.expire_year = "2020";
                payment_source.card_ccv = "123";
            customer.payment_source = payment_source;
        charge.customer = customer;
        return new Charges().authorise(charge);
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
        ChargeRequestStripeConnect.MetaData meta = new ChargeRequestStripeConnect.MetaData();
        meta.stripe_transfer_group = PayDock.StripeTransferGroup; // stripe transfer group id
            ChargeRequestStripeConnect.Transfer transfer1 = new ChargeRequestStripeConnect.Transfer(); //set up first transfer in array
                transfer1.amount = new BigDecimal(80);
                transfer1.currency = "AUD";
                transfer1.destination = PayDock.StripeDestinationAccount1;
            ChargeRequestStripeConnect.Transfer transfer2 = new ChargeRequestStripeConnect.Transfer(); //set up second transfer in array
                transfer2.amount = new BigDecimal(10);
                transfer2.currency = "AUD";
                transfer2.destination = PayDock.StripeDestinationAccount2;
        meta.stripe_transfer = new ChargeRequestStripeConnect.Transfer[] {transfer1,transfer2};
        charge.meta = meta;
        return new Charges().add(charge);
    }

    private ChargeItemsResponse CreateSearchCharge(String gatewayId) throws Exception {
        ChargeSearchRequest request = new ChargeSearchRequest();
        request.gateway_id = gatewayId;
        request.created_at_from = Date.from(LocalDate.of(2017, Month.DECEMBER, 19).atStartOfDay(ZoneId.systemDefault()).toInstant());
        request.created_at_to = new Date(); //Get Date today;

        return new Charges().get(request);
    }

    @Test
    public void add() throws Exception {
        ChargeResponse charge = CreateBasicCharge(new BigDecimal("7"), PayDock.GatewayId,
                "test@email.com");
        Assert.assertTrue(charge.get_IsSuccess());
    }

    @Test
    public void addBank() throws Exception {
        ChargeResponse charge = CreateBankCharge(new BigDecimal("7"), PayDock.BankGatewayId,
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
    public void authorise() throws Exception {
        ChargeResponse charge = CreateBasicChargeAuthorisation(new BigDecimal("8"), PayDock.StripeGatewayId,
                "test@email.com");
        Assert.assertTrue(charge.get_IsSuccess());
    }

    @Test
    public void capture() throws Exception {
        ChargeResponse charge = CreateBasicChargeAuthorisation(new BigDecimal("14"), PayDock.StripeGatewayId,
                "test@email.com");
        ChargeResponse result = new Charges().capture(charge.resource.data._id);
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void capture1() throws Exception {
        ChargeResponse charge = CreateBasicChargeAuthorisation(new BigDecimal("7"), PayDock.StripeGatewayId,
                "test@email.com");
        ChargeResponse result = new Charges().capture(charge.resource.data._id, new BigDecimal("7"));
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void cancelauthorisation() throws Exception {
        ChargeResponse charge = CreateBasicChargeAuthorisation(new BigDecimal("4"), PayDock.StripeGatewayId,
                "test@email.com");
        ChargeResponse result = new Charges().cancelauthorisation(charge.resource.data._id);
        Assert.assertTrue(result.get_IsSuccess());
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