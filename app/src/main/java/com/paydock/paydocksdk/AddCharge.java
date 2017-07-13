package com.paydock.paydocksdk;

import android.os.AsyncTask;

import com.paydock.paydocksdk.Models.ChargeRequest;
import com.paydock.paydocksdk.Models.ChargeResponse;
import com.paydock.paydocksdk.Models.Customer;
import com.paydock.paydocksdk.Models.PaymentSource;
import com.paydock.paydocksdk.Models.ResponseException;
import com.paydock.paydocksdk.Services.Charges;
import com.paydock.paydocksdk.Services.Config;
import com.paydock.paydocksdk.Services.Environment;

import java.math.BigDecimal;


/**
 * Created by Mark on 13/02/2016.
 */
public class AddCharge extends AsyncTask<Void, Void, ChargeResponse>{


    public interface AsyncResponse {
        void processFinish(ChargeResponse output);
    }
    public AsyncResponse delegate = null;

    public AddCharge(AsyncResponse delegate){
        this.delegate = delegate;
    }

    @Override
    protected void onPreExecute() {
    }


    @Override
    protected ChargeResponse doInBackground(Void... arg0) {
        String SecretKey = "c3de8f40ebbfff0fb74c11154274c080dfb8e3f99";
        String GatewayId = "58dba2dc5219634f922f79c3";
        String PaypalGatewayId = "58ede3577f8ce1233621d1bb";
        String PublicKey = "b2dad5fcf18f6f504685a46af0df82216781f3";

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
                Config.initialise(Environment.Sandbox, SecretKey, PublicKey);
                ch =  new Charges().add(charge);
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
    protected void onPostExecute(ChargeResponse ch) {
        super.onPostExecute(ch);
        delegate.processFinish(ch);
    }
}



