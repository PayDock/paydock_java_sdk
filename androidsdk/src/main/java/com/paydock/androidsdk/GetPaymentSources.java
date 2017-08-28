package com.paydock.androidsdk;

import android.os.AsyncTask;

import com.paydock.javasdk.Models.CustomerPaymentSourceSearchRequest;
import com.paydock.javasdk.Models.CustomerPaymentSourceSearchResponse;
import com.paydock.javasdk.Models.ResponseException;
import com.paydock.javasdk.Services.Config;
import com.paydock.javasdk.Services.Customers;
import com.paydock.javasdk.Services.Environment;


public class GetPaymentSources extends AsyncTask<CustomerPaymentSourceSearchRequest, Void, CustomerPaymentSourceSearchResponse>{


    private Environment mEnvironment = Environment.Sandbox;
    private IGetPaymentSources mDelegate = null;
    private String mPublicKey = "";
    private CustomerPaymentSourceSearchResponse mCustomerPaymentSourceSearchResponse = null;

    private Exception mException = null;

    public GetPaymentSources(Environment environment, String publicKey, IGetPaymentSources delegate){
        mEnvironment = environment;
        mPublicKey = publicKey;
        mDelegate = delegate;
    }

    @Override
    protected void onPreExecute() {
    }


    @Override
    protected CustomerPaymentSourceSearchResponse doInBackground(CustomerPaymentSourceSearchRequest... arg0) {

        try{
            Config.initialise(mEnvironment, "", mPublicKey);
            CustomerPaymentSourceSearchResponse ch =  new Customers().get(arg0[0]);
            mCustomerPaymentSourceSearchResponse = ch;
        }catch (ResponseException er){
            //handle Paydock exception
            mCustomerPaymentSourceSearchResponse.error = er.errorResponse;
        }catch (Exception e){
            //handle general exception
        }
        return mCustomerPaymentSourceSearchResponse;
    }

    @Override
    protected void onPostExecute(CustomerPaymentSourceSearchResponse ch) {
        super.onPostExecute(ch);
        mDelegate.paymentSourcesCallback(ch);
    }
}



