package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.CustomerItemResponse;
import com.paydock.javasdk.Models.CustomerItemsResponse;
import com.paydock.javasdk.Models.CustomerPaymentSourceSearchRequest;
import com.paydock.javasdk.Models.CustomerPaymentSourceSearchResponse;
import com.paydock.javasdk.Models.CustomerRequest;
import com.paydock.javasdk.Models.CustomerResponse;
import com.paydock.javasdk.Models.CustomerSearchRequest;
import com.paydock.javasdk.Models.CustomerUpdateRequest;
import com.paydock.javasdk.Models.PaymentSource;
import com.paydock.javasdk.PayDock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@SuppressWarnings("SameParameterValue")
@RunWith(JUnit4.class)
public class CustomersTest {

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, PayDock.SecretKey, PayDock.PublicKey);
    }

    private CustomerResponse CreateBasicCustomer(String customerEmail) throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.first_name = "John";
        customer.last_name = "Smith";
        customer.email = customerEmail;
        customer.reference = "CustomerReference";
        customer.phone = "+61412123123";
            PaymentSource payment_source = new PaymentSource();
            payment_source.gateway_id = PayDock.GatewayId;
            payment_source.card_name = "Test Name";
            payment_source.card_number = "5520000000000000";
            payment_source.expire_month = "10";
            payment_source.expire_year = "2020";
            payment_source.card_ccv = "123";
        customer.payment_source = (payment_source);

        return new Customers().add(customer);
    }

    private CustomerItemsResponse CreateSearchCustomer(String gatewayId) throws Exception {
        CustomerSearchRequest request = new CustomerSearchRequest();
        request.gateway_id = gatewayId;
        return new Customers().get(request);
    }

    @Test
    public void add() throws Exception {
        CustomerResponse customer = CreateBasicCustomer("test@email.com");
        Assert.assertTrue(customer.get_IsSuccess());
    }

    @Test
    public void get() throws Exception {
        CustomerItemsResponse result = new Customers().get();
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void get1() throws Exception {
        CustomerItemsResponse result = CreateSearchCustomer(PayDock.GatewayId);
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void get2() throws Exception {
        CustomerResponse customer = CreateBasicCustomer("test@email.com");
        CustomerItemResponse result = new Customers().get(customer.resource.data._id);
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void get3() throws Exception {
        CustomerResponse customer = CreateBasicCustomer("test@email.com");
        CustomerItemResponse result = new Customers().get(customer.resource.data._id);
        CustomerSearchRequest request = new CustomerSearchRequest();
        request._id = result.resource.data._id;
        CustomerItemsResponse result1 = new Customers().get(request);
        CustomerPaymentSourceSearchRequest request1 = new CustomerPaymentSourceSearchRequest();
        request1.query_token = result1.resource.query_token;
        CustomerPaymentSourceSearchResponse result2 = new Customers().get(request1);
        Assert.assertTrue(result2.get_IsSuccess());
    }

    @Test
    public void get4() throws Exception {
        CustomerResponse customer = CreateBasicCustomer("test@email.com");
        String result = new Customers().getQueryToken(customer.resource.data._id);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void update() throws Exception {
        CustomerResponse customer = CreateBasicCustomer("test@email.com");
        CustomerUpdateRequest request = new CustomerUpdateRequest();
        request.customer_id = customer.resource.data._id;
        request.first_name = "john1";
        request.last_name = "smith1";
        PaymentSource payment_source = new PaymentSource();
            payment_source.gateway_id = PayDock.GatewayId;
            payment_source.card_name = "Test Name";
            payment_source.card_number = "5520000000000000";
            payment_source.expire_month = "10";
            payment_source.expire_year = "2020";
            payment_source.card_ccv = "123";
        request.payment_source = payment_source;

        CustomerItemResponse result = new Customers().update(request);
        Assert.assertTrue(result.get_IsSuccess());

    }

    @Test
    public void delete() throws Exception {
        CustomerResponse customer = CreateBasicCustomer("test@email.com");
        CustomerItemResponse delete = new Customers().delete(customer.resource.data._id);
        Assert.assertTrue(delete.get_IsSuccess());
    }

}