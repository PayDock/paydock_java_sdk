package com.paydock.paydocksdk;

import android.os.AsyncTask;

import com.paydock.paydocksdk.Models.ChargeRequest;
import com.paydock.paydocksdk.Models.ChargeResponse;
import com.paydock.paydocksdk.Models.ResponseException;
import com.paydock.paydocksdk.Services.Charges;
import com.paydock.paydocksdk.Services.Config;
import com.paydock.paydocksdk.Services.Environment;


/**
 * Created by Mark on 13/02/2016.
 */
public class AddCharge extends AsyncTask<ChargeRequest, Void, ChargeResponse>{


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
    protected ChargeResponse doInBackground(ChargeRequest... arg0) {
          ChargeResponse ch = new ChargeResponse();
            try{
                Config.initialise(Environment.Sandbox, "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9", "8b2dad5fcf18f6f504685a46af0df82216781f3b");
                ch =  new Charges().add(arg0[0]);
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



