package com.paydock.paydocksdk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.paydock.paydocksdk.Models.ChargeResponse;
import com.paydock.paydocksdk.Models.CustomerResponse;


public class MainActivity extends Activity {

    Button bAddCharge, bAddCustomer, bClearText;
    EditText etEditText, editText, editText2, editText3, editText4, editText5, editText6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAddCharge = (Button) findViewById(R.id.bAddCharge);
        bAddCustomer = (Button) findViewById(R.id.bAddCustomer);
        bClearText = (Button) findViewById(R.id.bClearText);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);

        editText.setText("test");


        bAddCharge.setOnClickListener(v -> new AddCharge(output -> {
            //Here you will receive the result fired from async class
            //of onPostExecute(result) method.
            ChargeResponse ch = output;
            if (ch.resource != null) {
                editText.setText(ch.resource.data.customer.first_name);
                editText2.setText(ch.resource.data.customer.last_name);
                editText3.setText(ch.resource.data.customer.email);
                editText4.setText(ch.resource.data.customer.reference);
                editText5.setText(ch.resource.data.amount.toString());
                editText6.setText(ch.resource.data.status);
            }else if (ch.error != null){
                editText.setText(ch.error.http_status_code.toString());
                editText2.setText(ch.error.message);
                editText3.setText(ch.error.jsonResponse);
            }

        }).execute());

        bClearText.setOnClickListener(v -> {
            editText.setText("..");
            editText2.setText("");
            editText3.setText("");
            editText4.setText("");
            editText5.setText("");
            editText6.setText("");
        });

        bAddCustomer.setOnClickListener(v -> new AddCustomer(output -> {
            //Here you will receive the result fired from async class
            //of onPostExecute(result) method.
            CustomerResponse ch = output;
            if (ch.resource != null) {
                editText.setText(ch.resource.data.first_name);
                editText2.setText(ch.resource.data.last_name);
                editText3.setText(ch.resource.data.email);
                editText4.setText(ch.resource.data._id);
                editText5.setText(ch.resource.data.phone);
                editText6.setText(ch.resource.data.status);
            }else if (ch.error != null){
                editText.setText(ch.error.http_status_code.toString());
                editText2.setText(ch.error.message);
                editText3.setText(ch.error.jsonResponse);
            }
        }).execute());

    }
}
