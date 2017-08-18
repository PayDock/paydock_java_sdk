
package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.CustomerItemResponse;
import com.paydock.javasdk.Models.CustomerItemsResponse;
import com.paydock.javasdk.Models.CustomerResponse;
import com.paydock.javasdk.Models.CustomerUpdateRequest;
import com.paydock.javasdk.Models.CustomerRequest;
import com.paydock.javasdk.Models.CustomerSearchRequest;

@SuppressWarnings("unused")
public interface ICustomers
{
    CustomerResponse add(CustomerRequest request) throws Exception ;
    CustomerItemResponse delete(String customerId) throws Exception ;
    CustomerItemsResponse get() throws Exception ;
    CustomerItemResponse get(String customerId) throws Exception ;
    CustomerItemsResponse get(CustomerSearchRequest request) throws Exception ;
    CustomerItemResponse update(CustomerUpdateRequest request) throws Exception ;
}


