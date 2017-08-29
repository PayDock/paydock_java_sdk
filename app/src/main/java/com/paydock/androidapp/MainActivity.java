package com.paydock.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.paydock.javasdk.Models.ChargeRequest;
import com.paydock.javasdk.Models.ChargeResponse;
import com.paydock.javasdk.Models.Customer;
import com.paydock.javasdk.Models.PaymentSource;

import java.math.BigDecimal;


public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    Button bAddCharge, bGetToken, bClearText;
    EditText editText, editText2, editText3, editText4, editText5, editText6;


    String mToken = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate Bundle called", new Exception());

        bAddCharge = findViewById(R.id.bAddCharge);
        bGetToken = findViewById(R.id.bGetToken);
        bClearText = findViewById(R.id.bClearText);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);

        bAddCharge.setOnClickListener(v -> new AddCharge(output -> {
            ChargeResponse ch = output;
            if (ch.resource != null) {
                editText.setText(ch.resource.data.customer.first_name);
                editText2.setText(ch.resource.data.customer.last_name);
                editText3.setText(ch.resource.data.customer.email);
                editText4.setText(ch.resource.data.reference);
                editText5.setText(ch.resource.data.amount.toString());
                editText6.setText(ch.resource.data.status);
            } else if (ch.error != null) {
                editText.setText(ch.error.http_status_code.toString());
                editText2.setText(ch.error.message);
                editText3.setText(ch.error.jsonResponse);
            }
        }).execute(createCharge()));

    }

    public ChargeRequest createCharge() {
        ChargeRequest charge = new ChargeRequest();
        charge.currency ="AUD";
        charge.amount =new BigDecimal(10);
        charge.reference = "Charge reference";
        if (mToken != null) {
            charge.token = mToken;
        } else {
            Customer customer = new Customer();
            customer.first_name = "Justin";
            customer.last_name = "Timberlake";
            customer.email = "test@email.com";
            PaymentSource payment_source = new PaymentSource();
            payment_source.gateway_id = "58b60d8a6da7e425d6e4f6c7";
            payment_source.card_name = "Test Name";
            payment_source.card_number = "4111111111111111";
            payment_source.expire_month = "10";
            payment_source.expire_year = "2020";
            payment_source.card_ccv = "123";
            customer.payment_source = payment_source;
            charge.customer = customer;
        }

        return charge;
    }


}
