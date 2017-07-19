package com.paydock.paydocksdk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.paydock.paydocksdk.Models.CustomerRequest;
import com.paydock.paydocksdk.Models.CustomerResponse;
import com.paydock.paydocksdk.Models.PaymentSource;
import com.paydock.paydocksdk.Models.TokenRequest;
import com.paydock.paydocksdk.Models.TokenResponse;

/**
 * Created by Mark on 13/07/2017.
 */

public class TokenActivity extends Activity {

    EditText etCreditCardNumber;
    EditText etExpiryMonth;
    EditText etExpiryYear;
    EditText etExpiryCVC;
    EditText etCardName;
    TextView tvToken;
    String token = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_input);

        etCreditCardNumber = ((EditText) findViewById(R.id.etCreditCardNumber));
        etExpiryMonth = ((EditText) findViewById(R.id.etExpiryMonth));
        etExpiryYear = ((EditText) findViewById(R.id.etExpiryYear));
        etExpiryCVC = ((EditText) findViewById(R.id.etExpiryCVC));
        etCardName = ((EditText) findViewById(R.id.etCardName));
        tvToken = ((TextView) findViewById(R.id.tvToken));
        Button bSubmitCard = ((Button) findViewById(R.id.bSubmitCard));
        Button bCreateCustomer = ((Button) findViewById(R.id.bCreateCustomer));

        bSubmitCard.setOnClickListener(v -> new GetToken(output ->  {
            TokenResponse ch = output;
            if (ch.resource != null) {
                tvToken.setText(ch.resource.data);
                token = ch.resource.data;
            }else if (ch.error != null){
                tvToken.setText(ch.error.message);
            }
        }).execute(createToken()));

        bCreateCustomer.setOnClickListener(v -> new AddCustomer(output ->  {
            CustomerResponse ch = output;
            if (ch.resource != null) {
                tvToken.setText(ch.resource.data._id);
                token = ch.resource.data._id;
            }else if (ch.error != null){
                tvToken.setText(ch.error.message);
            }
        }).execute(createCustomer()));


    }

    public TokenRequest createToken(){
        TokenRequest tokenRequest = new TokenRequest() ;
        if(etCreditCardNumber.getText().length() < 15 ||
                etExpiryMonth.getText().length() != 2 ||
                etExpiryYear.getText().length() != 4 ||
                etExpiryCVC.getText().length() < 3 ||
                etCardName.getText().length() == 0) {
            tvToken.setText("Wrong parameters");
        }else{
            tokenRequest.gateway_id = "58b60d8a6da7e425d6e4f6c7";
            tokenRequest.card_name = etCardName.getText().toString();
            tokenRequest.card_number = etCreditCardNumber.getText().toString();
            tokenRequest.expire_month = etExpiryMonth.getText().toString();
            tokenRequest.expire_year = etExpiryYear.getText().toString();
            tokenRequest.card_ccv = etExpiryCVC.getText().toString();
        }
        return tokenRequest;
    }

    public CustomerRequest createCustomer() {
        CustomerRequest customer = new CustomerRequest();
        customer.first_name = "John";
        customer.last_name = "Smith";
        customer.email = "testing@email.com";
        customer.reference = "CustomerReference";
        customer.phone = "+61412123123";
        customer.token = token;

        return customer;
    }

}
