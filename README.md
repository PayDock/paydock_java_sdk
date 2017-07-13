# Welcome to Paydock java SDK 

This SDK provides a wrapper around the PayDock REST API.

For more info on the Paydock API, see our [full documentation](https://docs.paydock.com).

## Simple example to create a single charge
```Java

ChargeRequest charge = new ChargeRequest();
        charge.currency = "AUD";
        charge.amount = new BigDecimal(10);
        Customer customer = new Customer();
        customer.first_name = "Justin";
        customer.last_name = "Timberlake";
        customer.email = "test@email.com";
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
            try{
                Config.initialise(Environment.Sandbox, "<your secret key here>", "<your public key here>");
                ch =  new Charges().add(charge);
            }catch (ResponseException er){
                //handle Paydock exception
                ch.error.message = er.errorResponse.message;
                ch.error.http_status_code = er.errorResponse.http_status_code;
                ch.error.jsonResponse = er.errorResponse.jsonResponse;
            }catch (Exception e){
                //handle general exception
            }

```

## Simple example to create a customer
```Java

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
            try{
                Config.initialise(Environment.Sandbox, SecretKey, PublicKey);
                ch =  new Customers().add(customer);
            }catch (ResponseException er){
                //handle Paydock exception
                ch.error.message = er.errorResponse.message;
                ch.error.http_status_code = er.errorResponse.http_status_code;
                ch.error.jsonResponse = er.errorResponse.jsonResponse;
            }catch (Exception e){
                //handle general exception
            }

```
