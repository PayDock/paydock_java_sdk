package com.paydock.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.paydock.androidsdk.IGetToken;
import com.paydock.androidsdk.Models.TokenCardResponse;
import com.paydock.androidsdk.View.CreditCardInputForm;
import com.paydock.androidsdk.View.DirectDebitInputForm;
import com.paydock.javasdk.Models.ChargeRequest;
import com.paydock.javasdk.Models.ChargeResponse;
import com.paydock.javasdk.Models.Customer;
import com.paydock.javasdk.Models.PaymentSource;
import com.paydock.javasdk.Services.Environment;

import java.math.BigDecimal;


public class MainActivity extends Activity implements IGetToken {

    public static final String TAG = "MainActivity";

    Button bAddCharge, bGetToken, bClearText;
    EditText editText, editText2, editText3, editText4, editText5, editText6;

    CreditCardInputForm mCreditCardInputForm;
    DirectDebitInputForm mDirectDebitInputForm;

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
        mCreditCardInputForm = findViewById(R.id.creditCardInputForm);
        mDirectDebitInputForm = findViewById(R.id.directDebitInputForm);

        mCreditCardInputForm.setVisibility(View.INVISIBLE);
        mCreditCardInputForm.setVisibility(View.GONE);
        mDirectDebitInputForm.setVisibility(View.VISIBLE);

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



        bClearText.setOnClickListener(v -> {
            if (mCreditCardInputForm.getVisibility() == View.VISIBLE) {
                mCreditCardInputForm.clear();
            } else if (mDirectDebitInputForm.getVisibility() == View.VISIBLE) {
                mDirectDebitInputForm.clear();
            }

        });


        bGetToken.setOnClickListener(v -> {
            try {
                if (mCreditCardInputForm.getVisibility() == View.VISIBLE) {
                    mCreditCardInputForm.getToken(Environment.Sandbox,
                            "8b2dad5fcf18f6f504685a46af0df82216781f3b", "58b60d8a6da7e425d6e4f6c7", this);
                } else if (mDirectDebitInputForm.getVisibility() == View.VISIBLE) {
                    mDirectDebitInputForm.getToken(Environment.Sandbox,
                            "8b2dad5fcf18f6f504685a46af0df82216781f3b", "58bf7dd43c541b5b87f741df", this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

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

    //TODO: Handle Exceptions in Async callback

    @Override
    public void processFinish(TokenCardResponse output){
        try {
            mToken = output.data;
            new AddCharge(output1 -> {
                ChargeResponse ch = output1;
                if (ch.resource != null) {
                    editText.setText(ch.resource.data._id);
                    editText2.setText(ch.resource.data.amount.toString());
                    editText3.setText(ch.resource.data.external_id);
                    editText4.setText(ch.resource.data.reference);
                    editText5.setText(ch.resource.data.amount.toString());
                    editText6.setText(ch.resource.data.status);
                } else if (ch.error != null) {
                    editText.setText(ch.error.http_status_code.toString());
                    editText2.setText(ch.error.message);
                    editText3.setText(ch.error.jsonResponse);
                }
            }).execute(createCharge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
