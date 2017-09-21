package com.paydock.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.paydock.javasdk.Models.ChargeRequest;
import com.paydock.javasdk.Models.ChargeResponse;
import com.paydock.javasdk.Models.Customer;
import com.paydock.javasdk.Models.PaymentSource;

import java.math.BigDecimal;


public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";
    public static String publicKey = "8b2dad5fcf18f6f504685a46af0df82216781f3b";
    public static String privateKey = "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9";
    public static String gatewayID = "58b60d8a6da7e425d6e4f6c7";

    Button bAddCharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate Bundle called", new Exception());

        bAddCharge = findViewById(R.id.bAddCharge);

        bAddCharge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AddCharge(new AddCharge.AsyncResponse(){
                    @Override
                    public void processFinish(ChargeResponse output) {
                        displayPopup(output);
                    }
                }).execute(createCharge());
            }
        });


    }

    public ChargeRequest createCharge() {
        ChargeRequest charge = new ChargeRequest();
        charge.currency ="AUD";
        charge.amount =new BigDecimal(10);
        charge.reference = "Charge reference";
        Customer customer = new Customer();
        customer.first_name = "Justin";
        customer.last_name = "Timberlake";
        customer.email = "test@email.com";
        PaymentSource payment_source = new PaymentSource();
        payment_source.gateway_id = gatewayID;
        payment_source.card_name = "Test Name";
        payment_source.card_number = "4111111111111111";
        payment_source.expire_month = "10";
        payment_source.expire_year = "2020";
        payment_source.card_ccv = "123";
        customer.payment_source = payment_source;
        charge.customer = customer;

        return charge;
    }

    void displayPopup(ChargeResponse chargeResponse) {
        if (chargeResponse.resource != null) {
            String notification = chargeResponse.resource.data._id + "\r\n" +
                    chargeResponse.resource.data.amount.toString() + "\r\n" +
                    chargeResponse.resource.data.external_id + "\r\n" +
                    chargeResponse.resource.data.reference + "\r\n" +
                    chargeResponse.resource.data.amount.toString() + "\r\n" +
                    chargeResponse.resource.data._id + "\r\n" +
                    chargeResponse.resource.data.status;
            Toast.makeText(getApplicationContext(), notification, Toast.LENGTH_LONG).show();
        } else if (chargeResponse.error != null) {
            String notification = chargeResponse.error.http_status_code.toString() + "\r\n" +
                    chargeResponse.error.message + "\r\n" + chargeResponse.error.jsonResponse;
            Toast.makeText(getApplicationContext(), notification, Toast.LENGTH_LONG).show();
        }
    }


}
