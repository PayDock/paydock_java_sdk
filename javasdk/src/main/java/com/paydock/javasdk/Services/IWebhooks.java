package com.paydock.javasdk.Services;


import com.paydock.javasdk.Models.WebhookCardExpiration;
import com.paydock.javasdk.Models.WebhookSubscriptionEvents;
import com.paydock.javasdk.Models.WebhookSubscriptionTransaction;
import com.paydock.javasdk.Models.WebhookTransaction;

public interface IWebhooks {

    WebhookCardExpiration ParseCardExpiry(String postData);
    WebhookSubscriptionEvents ParseSubscriptionEvent(String postData);
    WebhookSubscriptionTransaction ParseSubscriptionTransaction(String postData);
    WebhookTransaction ParseTransaction(String postData);
}
