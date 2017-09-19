package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.WebhookCardExpiration;
import com.paydock.javasdk.Models.WebhookSubscriptionTransaction;
import com.paydock.javasdk.Models.WebhookTransaction;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@RunWith(JUnit4.class)
public class WebhooksTest {


    @Test
    public void transaction_success() throws Exception {
        String postData = loadFile("javasdk//Webhooks//transaction_success.json");
        WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);
        Assert.assertEquals("transaction_success", webhookTransaction.event);
    }

    @Test
    public void transaction_failure() throws Exception {
        String postData = loadFile("javasdk//Webhooks//transaction_failure.json");
        WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);
        Assert.assertEquals("transaction_failure", webhookTransaction.event);
    }

    @Test
    public void transaction_subscription_success() throws Exception {
        String postData = loadFile("javasdk//Webhooks//transaction_subscription_success.json");
        WebhookSubscriptionTransaction webhooksubscriptionTransaction = new Webhooks().
                ParseSubscriptionTransaction(postData);
        Assert.assertEquals("subscription_transaction", webhooksubscriptionTransaction.event);
    }

    @Test
    public void transaction_subscription_failure() throws Exception {
        String postData = loadFile("javasdk//Webhooks//transaction_subscription_failure.json");
        WebhookSubscriptionTransaction webhooksubscriptionTransaction = new Webhooks().
                ParseSubscriptionTransaction(postData);
        Assert.assertEquals("subscription_transaction_failure", webhooksubscriptionTransaction.event);
    }

    @Test
    public void subscription_creation_success() throws Exception {
        String postData = loadFile("javasdk//Webhooks//subscription_creation_success.json");
        WebhookSubscriptionTransaction webhooksubscriptionTransaction = new Webhooks().
                ParseSubscriptionTransaction(postData);
        Assert.assertEquals("subscription_creation_success", webhooksubscriptionTransaction.event);
    }

    @Test
    public void subscription_creation_failure() throws Exception {
        String postData = loadFile("javasdk//Webhooks//subscription_creation_failure.json");
        WebhookSubscriptionTransaction webhooksubscriptionTransaction = new Webhooks().
                ParseSubscriptionTransaction(postData);
        Assert.assertEquals("subscription_creation_failure", webhooksubscriptionTransaction.event);
    }

    @Test
    public void subscription_finished() throws Exception {
        String postData = loadFile("javasdk//Webhooks//subscription_finished.json");
        WebhookSubscriptionTransaction webhooksubscriptionTransaction = new Webhooks().
                ParseSubscriptionTransaction(postData);
        Assert.assertEquals("subscription_finished", webhooksubscriptionTransaction.event);
    }

    @Test
    public void subscription_updated() throws Exception {
        String postData = loadFile("javasdk//Webhooks//subscription_updated.json");
        WebhookSubscriptionTransaction webhooksubscriptionTransaction = new Webhooks().
                ParseSubscriptionTransaction(postData);
        Assert.assertEquals("subscription_updated", webhooksubscriptionTransaction.event);
    }

    @Test
    public void subscription_failed() throws Exception {
        String postData = loadFile("javasdk//Webhooks//subscription_failed.json");
        WebhookSubscriptionTransaction webhooksubscriptionTransaction = new Webhooks().
                ParseSubscriptionTransaction(postData);
        Assert.assertEquals("subscription_failed", webhooksubscriptionTransaction.event);
    }

    @Test
    public void transaction_refund_request() throws Exception {
        String postData = loadFile("javasdk//Webhooks//transaction_refund_request.json");
        WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);
        Assert.assertEquals("refund_requested", webhookTransaction.event);
    }

    @Test
    public void transaction_refund_success() throws Exception {
        String postData = loadFile("javasdk//Webhooks//transaction_refund_success.json");
        WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);
        Assert.assertEquals("refund_success", webhookTransaction.event);
    }

    @Test
    public void transaction_refund_failure() throws Exception {
        String postData = loadFile("javasdk//Webhooks//transaction_refund_failure.json");
        WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);
        Assert.assertEquals("refund_failure", webhookTransaction.event);
    }

    @Test
    public void card_expiration_warning() throws Exception {
        String postData = loadFile("javasdk//Webhooks//card_expiration_warning.json");
        WebhookCardExpiration webhookCardExpiration = new Webhooks().ParseCardExpiry(postData);
        Assert.assertEquals("card_expiration_warning", webhookCardExpiration.event);
    }

    private String loadFile(String path){
        try{
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            StringBuilder response = new StringBuilder();
            String line;
            while((line = Buffreader.readLine()) != null){
                response.append(line).append('\n');
            }
            line = response.toString();
            return line;

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}