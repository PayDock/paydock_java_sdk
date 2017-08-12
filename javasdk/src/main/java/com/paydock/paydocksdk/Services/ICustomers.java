
package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.CustomerItemResponse;
import com.paydock.paydocksdk.Models.CustomerItemsResponse;
import com.paydock.paydocksdk.Models.CustomerRequest;
import com.paydock.paydocksdk.Models.CustomerResponse;
import com.paydock.paydocksdk.Models.CustomerSearchRequest;
import com.paydock.paydocksdk.Models.CustomerUpdateRequest;

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


