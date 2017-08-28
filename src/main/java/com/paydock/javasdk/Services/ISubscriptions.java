
package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.SubscriptionItemResponse;
import com.paydock.javasdk.Models.SubscriptionItemsResponse;
import com.paydock.javasdk.Models.SubscriptionRequest;
import com.paydock.javasdk.Models.SubscriptionResponse;
import com.paydock.javasdk.Models.SubscriptionSearchRequest;
import com.paydock.javasdk.Models.SubscriptionUpdateRequest;

@SuppressWarnings("unused")
public interface ISubscriptions
{
    SubscriptionResponse add(SubscriptionRequest request) throws Exception ;
    SubscriptionItemResponse delete(String subscriptionId) throws Exception ;
    SubscriptionItemsResponse get() throws Exception ;
    SubscriptionItemsResponse get(SubscriptionSearchRequest request) throws Exception ;
    SubscriptionItemResponse get(String subscriptionId) throws Exception ;
    SubscriptionResponse update(SubscriptionUpdateRequest request) throws Exception ;
}


