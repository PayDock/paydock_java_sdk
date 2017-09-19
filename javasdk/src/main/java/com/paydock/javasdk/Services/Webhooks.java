package com.paydock.javasdk.Services;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.javasdk.Models.WebhookCardExpiration;
import com.paydock.javasdk.Models.WebhookSubscriptionEvents;
import com.paydock.javasdk.Models.WebhookSubscriptionTransaction;
import com.paydock.javasdk.Models.WebhookTransaction;

public class Webhooks implements IWebhooks{


    @Override
    public WebhookCardExpiration ParseCardExpiry(String postData) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(postData, WebhookCardExpiration.class);
    }

    @Override
    public WebhookSubscriptionEvents ParseSubscriptionEvent(String postData) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(postData, WebhookSubscriptionEvents.class);
    }

    @Override
    public WebhookSubscriptionTransaction ParseSubscriptionTransaction(String postData) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(postData, WebhookSubscriptionTransaction.class);
    }

    @Override
    public WebhookTransaction ParseTransaction(String postData) {
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(postData, WebhookTransaction.class);
    }
}
