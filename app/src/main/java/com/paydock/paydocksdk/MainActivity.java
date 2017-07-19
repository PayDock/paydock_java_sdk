package com.paydock.paydocksdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.paydock.paydocksdk.Models.ChargeRequest;
import com.paydock.paydocksdk.Models.ChargeResponse;
import com.paydock.paydocksdk.Models.Customer;
import com.paydock.paydocksdk.Models.CustomerRequest;
import com.paydock.paydocksdk.Models.CustomerResponse;
import com.paydock.paydocksdk.Models.PaymentSource;

import java.math.BigDecimal;


public class MainActivity extends Activity {

    Button bAddCharge, bAddCustomer, bClearText;
    EditText editText, editText2, editText3, editText4, editText5, editText6;


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

        bAddCustomer.setOnClickListener(v -> new AddCustomer(output -> {
            CustomerResponse ch = output;
            if (ch.resource != null) {
                editText.setText(ch.resource.data.first_name);
                editText2.setText(ch.resource.data.last_name);
                editText3.setText(ch.resource.data.email);
                editText4.setText(ch.resource.data._id);
                editText5.setText(ch.resource.data.phone);
                editText6.setText(ch.resource.data.status);
            } else if (ch.error != null) {
                editText.setText(ch.error.http_status_code.toString());
                editText2.setText(ch.error.message);
                editText3.setText(ch.error.jsonResponse);
            }
        }).execute(createCustomer()));

        bClearText.setOnClickListener(v -> {
            editText.setText("..");
            editText2.setText("");
            editText3.setText("");
            editText4.setText("");
            editText5.setText("");
            editText6.setText("");
            Intent intent = new Intent(MainActivity.this, TokenActivity.class);
            startActivity(intent);
        });
    }

    public CustomerRequest createCustomer() {
        CustomerRequest customer = new CustomerRequest();
        customer.first_name = "John";
        customer.last_name = "Smith";
        customer.email = "testing@email.com";
        customer.reference = "CustomerReference";
        customer.phone = "+61412123123";
        PaymentSource payment_source = new PaymentSource();
        payment_source.gateway_id = "58b60d8a6da7e425d6e4f6c7";
        payment_source.card_name = "Test Name";
        payment_source.card_number = "4111111111111111";
        payment_source.expire_month = "10";
        payment_source.expire_year = "2020";
        payment_source.card_ccv = "123";
        customer.payment_source = (payment_source);
        return customer;
    }

    public ChargeRequest createCharge() {
        ChargeRequest charge = new ChargeRequest();
        charge.currency ="AUD";
        charge.amount =new BigDecimal(10);
        charge.reference = "Charge reference";
        Customer customer = new Customer();
        customer.first_name ="Justin";
        customer.last_name ="Timberlake";
        customer.email ="test@email.com";
        PaymentSource payment_source = new PaymentSource();
        payment_source.gateway_id ="58b60d8a6da7e425d6e4f6c7";
        payment_source.card_name ="Test Name";
        payment_source.card_number ="4111111111111111";
        payment_source.expire_month ="10";
        payment_source.expire_year ="2020";
        payment_source.card_ccv ="123";
        customer.payment_source =payment_source;
        charge.customer =customer;
        return charge;
    }
}
