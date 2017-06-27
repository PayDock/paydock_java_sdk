package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.CustomerItemResponse;
import com.paydock.paydocksdk.Models.CustomerItemsResponse;
import com.paydock.paydocksdk.Models.CustomerResponse;
import com.paydock.paydocksdk.Models.CustomerSearchRequest;
import com.paydock.paydocksdk.Models.CustomerUpdateRequest;

import com.paydock.paydocksdk.Models.CustomerRequest;
import com.paydock.paydocksdk.Models.PaymentSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class CustomersTest {

    String SecretKey = "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9";
    String GatewayId = "58b60d8a6da7e425d6e4f6c7";
    String PaypalGatewayId = "58ede3577f8ce1233621d1bb";
    String PublicKey = "b2dad5fcf18f6f504685a46af0df82216781f3";

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, SecretKey, PublicKey);
    }

    private CustomerResponse CreateBasicCustomer(String customerEmail) throws Exception {
        CustomerRequest customer = new CustomerRequest();
        customer.set_first_name("John");
        customer.set_first_name("Smith");
        customer.set_email(customerEmail);
            PaymentSource payment_source = new PaymentSource();
            payment_source.set_gateway_id(GatewayId);
            payment_source.set_card_name("Test Name");
            payment_source.set_card_number("4111111111111111");
            payment_source.set_expire_month("10");
            payment_source.set_expire_year("2020");
            payment_source.set_card_ccv("123");
        customer.set_payment_source(payment_source);

        return new Customers().add(customer);
    }

    private CustomerItemsResponse CreateSearchCustomer(String gatewayId) throws Exception {
        CustomerSearchRequest request = new CustomerSearchRequest();
        request.set_gateway_id(gatewayId);
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
        CustomerItemsResponse result = CreateSearchCustomer(GatewayId);
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void get2() throws Exception {
        CustomerResponse customer = CreateBasicCustomer("test@email.com");
        CustomerItemResponse result = new Customers().get(customer.get_resource().get_data().get_id());
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void update() throws Exception {
        CustomerResponse customer = CreateBasicCustomer("test@email.com");
        CustomerUpdateRequest request = new CustomerUpdateRequest();
        request.set_customer_id(customer.get_resource().get_data().get_id());
        request.set_first_name("john1");
        request.set_last_name("smith1");
        PaymentSource payment_source = new PaymentSource();
            payment_source.set_gateway_id(GatewayId);
            payment_source.set_card_name("Test Name");
            payment_source.set_card_number("4111111111111111");
            payment_source.set_expire_month("12");
            payment_source.set_expire_year("2022");
            payment_source.set_card_ccv("123");
        request.set_payment_source(payment_source);

        CustomerItemResponse result = new Customers().update(request);
        Assert.assertTrue(result.get_IsSuccess());

    }

    @Test
    public void delete() throws Exception {
        CustomerResponse customer = CreateBasicCustomer("test@email.com");
        CustomerItemResponse delete = new Customers().delete(customer.get_resource().get_data().get_id());
        Assert.assertTrue(delete.get_IsSuccess());
    }

}