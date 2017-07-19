package com.paydock.paydocksdk;

import android.os.AsyncTask;

import com.paydock.paydocksdk.Models.ResponseException;
import com.paydock.paydocksdk.Models.TokenRequest;
import com.paydock.paydocksdk.Models.TokenResponse;
import com.paydock.paydocksdk.Services.Config;
import com.paydock.paydocksdk.Services.Environment;
import com.paydock.paydocksdk.Services.Tokens;



/**
 * Created by Mark on 13/02/2016.
 */
public class GetToken extends AsyncTask<TokenRequest, Void, TokenResponse>{


    public interface AsyncResponse {
        void processFinish(TokenResponse output);
    }
    public AsyncResponse delegate = null;

    public GetToken(AsyncResponse delegate){
        this.delegate = delegate;
    }

    @Override
    protected void onPreExecute() {
    }


    @Override
    protected TokenResponse doInBackground(TokenRequest... arg0) {
        TokenResponse ch = new TokenResponse();
        try{
            Config.initialise(Environment.Sandbox, "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9", "8b2dad5fcf18f6f504685a46af0df82216781f3b");
            ch =  new Tokens().create(arg0[0]);
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
    protected void onPostExecute(TokenResponse ch) {
        super.onPostExecute(ch);
        delegate.processFinish(ch);
    }
}



