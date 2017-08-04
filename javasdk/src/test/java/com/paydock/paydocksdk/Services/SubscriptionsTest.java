package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.SubscriptionItemResponse;
import com.paydock.paydocksdk.Models.SubscriptionItemsResponse;
import com.paydock.paydocksdk.Models.SubscriptionRequest;
import com.paydock.paydocksdk.Models.SubscriptionResponse;
import com.paydock.paydocksdk.Models.SubscriptionSchedule;
import com.paydock.paydocksdk.Models.SubscriptionSearchRequest;
import com.paydock.paydocksdk.Models.Customer;
import com.paydock.paydocksdk.Models.PaymentSource;
import com.paydock.paydocksdk.Models.SubscriptionUpdateRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("SameParameterValue")
@RunWith(JUnit4.class)
public class SubscriptionsTest {

    String SecretKey = "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9";
    String GatewayId = "58dba2dc5219634f922f79c3";
    String PaypalGatewayId = "58ede3577f8ce1233621d1bb";
    String PublicKey = "b2dad5fcf18f6f504685a46af0df82216781f3";

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, SecretKey, PublicKey);
    }

    private SubscriptionResponse CreateBasicSubscription(BigDecimal SubscriptionAmount, String gatewayId, String customerEmail) throws Exception {
        SubscriptionRequest subscription = new SubscriptionRequest();
        Customer customer = new Customer();
        PaymentSource payment_source = new PaymentSource();
        SubscriptionSchedule schedule = new SubscriptionSchedule();
        subscription.currency = "AUD";
        subscription.amount = SubscriptionAmount;
        subscription.description = "description";
            customer.first_name = "Justin";
            customer.last_name = "Timberlake";
            customer.email = "test@email.com";
                payment_source.gateway_id = gatewayId;
                payment_source.card_name = "Test Name";
                payment_source.card_number = "5520000000000000";
                payment_source.expire_month = "10";
                payment_source.expire_year = "2020";
                payment_source.card_ccv = "123";
            customer.payment_source = payment_source;
        subscription.customer = customer;
            schedule.interval = "day";
            schedule.frequency = 1;
            schedule.start_date = new Date();
            schedule.end_transactions = 2;
        subscription.schedule = schedule;
        return new Subscriptions().add(subscription);
    }

    private SubscriptionItemsResponse SearchSubscription(String gatewayId) throws Exception {
        SubscriptionSearchRequest request = new SubscriptionSearchRequest();
        request.gateway_id = gatewayId;
        return new Subscriptions().get(request);
    }

    @Test
    public void add() throws Exception {
        SubscriptionResponse subscription = CreateBasicSubscription(new BigDecimal("7"), GatewayId, "test@email.com");
        Assert.assertTrue(subscription.get_IsSuccess());
    }

    @Test
    public void update() throws Exception {
        SubscriptionResponse subscription = CreateBasicSubscription(new BigDecimal("8"), GatewayId, "test@email.com");
        SubscriptionUpdateRequest request = new SubscriptionUpdateRequest();
        request._id = subscription.resource.data._id;
        request.description = "descriptionAfter";
        SubscriptionResponse update = new Subscriptions().update(request);
        Assert.assertTrue(update.get_IsSuccess());
    }

    @Test
    public void get() throws Exception {
        SubscriptionItemsResponse result = new Subscriptions().get();
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void get1() throws Exception {
        SubscriptionItemsResponse result = SearchSubscription(GatewayId);
            Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void get2() throws Exception {
        SubscriptionResponse Subscription = CreateBasicSubscription(new BigDecimal("9"), GatewayId, "test@email.com");
        SubscriptionItemResponse result = new Subscriptions().get(Subscription.resource.data._id);
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void delete() throws Exception {
        SubscriptionResponse Subscription = CreateBasicSubscription(new BigDecimal("12"), GatewayId, "test@email.com");
        SubscriptionItemResponse delete = new Subscriptions().delete(Subscription.resource.data._id);
        Assert.assertTrue(delete.get_IsSuccess());
    }

}