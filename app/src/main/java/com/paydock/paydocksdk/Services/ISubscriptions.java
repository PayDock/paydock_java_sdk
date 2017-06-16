
package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.*;

public interface ISubscriptions
{
    SubscriptionResponse add(SubscriptionRequest request) throws Exception ;

    SubscriptionItemResponse delete(String subscriptionId) throws Exception ;

    SubscriptionItemsResponse get() throws Exception ;

    SubscriptionItemsResponse get(SubscriptionSearchRequest request) throws Exception ;

    SubscriptionItemResponse get(String subscriptionId) throws Exception ;

    SubscriptionResponse update(SubscriptionUpdateRequest request) throws Exception ;

}


