
package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.*;

public interface ICustomers
{
    CustomerResponse add(CustomerRequest request) throws Exception ;
    CustomerItemResponse delete(String customerId) throws Exception ;
    CustomerItemsResponse get() throws Exception ;
    CustomerItemResponse get(String customerId) throws Exception ;
    CustomerItemsResponse get(CustomerSearchRequest request) throws Exception ;
    CustomerItemResponse update(CustomerUpdateRequest request) throws Exception ;
}


