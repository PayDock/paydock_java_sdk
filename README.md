# Welcome to Paydock java SDK 

This SDK provides a wrapper around the PayDock REST API.

For more info on the Paydock API, see our [full documentation](https://docs.paydock.com).

## Getting access to the library

To download the library please visit https://bintray.com/markcardamis/javaSDK/javasdk.
There are different dependency snippets to be inserted in your code based on your selected repository (we support Gradle, Maven or Ivy).

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
    var tran = (new Webhook()).Parse<TransactionWebhook>(tranJson);
    
    // subscription webhook
    var subscription = (new Webhook()).Parse<SubscriptionWebhook>(subscriptionJson);
```
The different webhook types map to different data objects:/Users/markcardamis/Documents/AndroidStudioProjects/PayDockJavaSDK/javasdk/src/test/java/com/paydock/javasdk/WebhookSampleData/subscription_finished.json
                                                                                              /Users/markcardamis/Documents/AndroidStudioProjects/PayDockJavaSDK/src/test/java/com/paydock/javasdk/WebhookSampleData/subscription_finished.json

- Transaction Success -> Webhook.Parse()
- Transaction by Subscription Success -> Webhook.Parse()
- Transaction by Subscription Failed -> Webhook.Parse()
- Subscription Creation Success -> Webhook.Parse()
- Subscription Finished -> Webhook.Parse()
- Subscription Updated -> Webhook.Parse()
- Subscription Failed -> Webhook.Parse()
- Refund Requested -> Webhook.Parse()
- Refund Success -> Webhook.Parse()
- Refund Failure -> Webhook.Parse()
- Card Expiration Warning -> Webhook.Parse()

