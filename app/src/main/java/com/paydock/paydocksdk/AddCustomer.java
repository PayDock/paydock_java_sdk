package com.paydock.paydocksdk;

import android.os.AsyncTask;

import com.paydock.paydocksdk.Models.CustomerRequest;
import com.paydock.paydocksdk.Models.CustomerResponse;
import com.paydock.paydocksdk.Models.PaymentSource;
import com.paydock.paydocksdk.Models.ResponseException;
import com.paydock.paydocksdk.Services.Config;
import com.paydock.paydocksdk.Services.Customers;
import com.paydock.paydocksdk.Services.Environment;


/**
 * Created by Mark on 13/02/2016.
 */
public class AddCustomer extends AsyncTask<Void, Void, CustomerResponse>{


    public interface AsyncResponse {
        void processFinish(CustomerResponse output);
    }
    public AsyncResponse delegate = null;

    public AddCustomer(AsyncResponse delegate){
        this.delegate = delegate;
    }

    @Override
    protected void onPreExecute() {
    }


    @Override
    protected CustomerResponse doInBackground(Void... arg0) {
        String SecretKey = "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9";
        String GatewayId = "58b60d8a6da7e425d6e4f6c7";
        String PublicKey = "b2dad5fcf18f6f504685a46af0df82216781f3";

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

        return ch;
    }

    @Override
    protected void onPostExecute(CustomerResponse ch) {
        super.onPostExecute(ch);
        delegate.processFinish(ch);
    }
}



