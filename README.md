# Deprecation Notice: paydock_java_sdk is no longer supported or maintained.

We are deprecating the paydock_ios_sdk repository in favor of newer, better-maintained alternatives. This means that the code in this repository will not receive any updates, bug fixes, or security patches.

Please do not use this SDK for new development, as it will lead to compatibility issues and potential security risks. Instead, we recommend using direct REST API integration.

We apologize for any inconvenience this may cause, but we must prioritize the stability and security of our software.

If you have any questions or concerns, please open an issue in the repository or contact Paydock Support.

Thank you for your understanding.


# Welcome to Paydock java SDK 

This SDK provides a wrapper around the PayDock REST API.

For more info on the Paydock API, see our [full documentation](https://docs.paydock.com).

## Getting access to the library

To download the library please visit [JCentre](https://bintray.com/markcardamis/javaSDK/javasdk).
There are different dependency snippets to be inserted in your code based on your selected build settings (we support Gradle, Maven or Ivy).

Review the functional tests for more examples at https://github.com/PayDockDev/paydock_java_sdk/tree/master/javasdk/src/test/java/com/paydock/javasdk/Services

### Simple example to create a single charge
```java
    ChargeRequest charge = new ChargeRequest();
    charge.currency = "AUD";
    charge.amount = new BigDecimal(10);
    Customer customer = new Customer();
    PaymentSource payment_source = new PaymentSource();
    payment_source.gateway_id = GatewayId;
    payment_source.card_name = "Test Name";
    payment_source.card_number = "5520000000000000";
    payment_source.expire_month = "10";
    payment_source.expire_year = "2020";
    payment_source.card_ccv = "123";
    customer.payment_source = payment_source;
    charge.customer = customer;

    ChargeResponse ch = new ChargeResponse();

    try {
        Config.initialise(Environment.Sandbox, "<your secret key here>", "<your public key here>");
        ch =  new Charges().add(charge);
    } catch (ResponseException er) {
            //handle Paydock exception
            ch.error.message = er.errorResponse.message;
            ch.error.http_status_code = er.errorResponse.http_status_code;
            ch.error.jsonResponse = er.errorResponse.jsonResponse;
    } catch (Exception e) {
        //handle general exception
    }    
```
### Simple example to create a customer
```java
    CustomerRequest customer = new CustomerRequest();
    customer.first_name = "John";
    customer.last_name = "Smith";
    customer.email = "testing@email.com";
    customer.reference = "CustomerReference";
    customer.phone = "+61412123123";
    PaymentSource payment_source = new PaymentSource();
    payment_source.gateway_id = GatewayId;
    payment_source.card_name = "Test Name";
    payment_source.card_number = "4111111111111111";
    payment_source.expire_month = "10";
    payment_source.expire_year = "2020";
    payment_source.card_ccv = "123";
    customer.payment_source = (payment_source);

    CustomerResponse ch = new CustomerResponse();
    try {
        Config.initialise(Environment.Sandbox, "<your secret key here>", "<your public key here>");
        ch =  new Customers().add(customer);
    } catch (ResponseException er) {
        //handle Paydock exception
        ch.error.message = er.errorResponse.message;
        ch.error.http_status_code = er.errorResponse.http_status_code;
        ch.error.jsonResponse = er.errorResponse.jsonResponse;
    } catch (Exception e) {
        //handle general exception
    }
```
### Simple example to get a one-time token
```java
    TokenRequest tokenRequest = new TokenRequest() ;
    tokenRequest.gateway_id = GatewayId;
    tokenRequest.card_name = "Test Name";
    tokenRequest.card_number = "4111111111111111";
    tokenRequest.expire_month = "10";
    tokenRequest.expire_year = "2020";
    tokenRequest.card_ccv = "123";

    TokenResponse ch = new TokenResponse();
    try {
        Config.initialise(Environment.Sandbox, "", "<your public key here>");
        ch =  new Tokens().create(tokenRequest);
        String token = ch.resource.data; //Your  
    } catch (ResponseException er) {
        //handle Paydock exception
        ch.error.message = er.errorResponse.message;
        ch.error.http_status_code = er.errorResponse.http_status_code;
        ch.error.jsonResponse = er.errorResponse.jsonResponse;
    } catch (Exception e) {
        //handle general exception
    }
```
### Parsing a webhook

Webhooks are POSTed to the URL, once you've captured the payload, you can parse this:
```java
    // transaction webhook
    WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);
```
The different webhook types map to different data objects:

- Transaction Success
  `WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);`
- Transaction Failure
  `WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);`
- Transaction by Subscription Success
  `WebhookSubscriptionTransaction webhooksubscriptionTransaction = new Webhooks().ParseSubscriptionTransaction(postData);`
- Transaction by Subscription Failed
  `WebhookSubscriptionTransaction webhooksubscriptionTransaction = new Webhooks().ParseSubscriptionTransaction(postData);`
- Subscription Creation Success
  `WebhookSubscriptionEvents webhooksubscriptionEvents = new Webhooks().ParseSubscriptionEvent(postData);`
- Subscription Creation Failure
  `WebhookSubscriptionEvents webhooksubscriptionEvents = new Webhooks().ParseSubscriptionEvent(postData);`
- Subscription Finished
  `WebhookSubscriptionEvents webhooksubscriptionEvents = new Webhooks().ParseSubscriptionEvent(postData);`
- Subscription Updated
  `WebhookSubscriptionEvents webhooksubscriptionEvents = new Webhooks().ParseSubscriptionEvent(postData);`
- Subscription Failed
  `WebhookSubscriptionEvents webhooksubscriptionEvents = new Webhooks().ParseSubscriptionEvent(postData);`
- Refund Requested
  `WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);`
- Refund Success
  `WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);`
- Refund Failure
  `WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);`
- Card Expiration Warning
  `WebhookTransaction webhookTransaction = new Webhooks().ParseTransaction(postData);`
