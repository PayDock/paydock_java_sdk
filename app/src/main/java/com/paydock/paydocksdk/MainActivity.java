package com.paydock.paydocksdk;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import com.paydock.paydocksdk.Models.*;
import com.paydock.paydocksdk.Services.*;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    try {
                        Config.initialise(Environment.Sandbox, "c3de8f40ebbfff0fb74c11154274c080dfb8e3f9", "8b2dad5fcf18f6f504685a46af0df82216781f3b");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
//                                ChargeRequest charge = new ChargeRequest();
//                                charge.set_currency("AUD");
//                                charge.set_amount(new BigDecimal("19.2"));
//                                Customer customer = new Customer();
//                                customer.set_first_name("Justin");
//                                customer.set_last_name("Timberlake");
//                                customer.set_email("test@email.com");
//                                PaymentSource payment_source = new PaymentSource();
//                                payment_source.set_gateway_id("58b60d8a6da7e425d6e4f6c7");
//                                payment_source.set_card_name("Test Name");
//                                payment_source.set_card_number("4111111111111111");
//                                payment_source.set_expire_month("10");
//                                payment_source.set_expire_year("2020");
//                                payment_source.set_card_ccv("123");
//                                customer.set_payment_source(payment_source);
//                                charge.set_customer(customer);

                                //ChargeSearchRequest request = new ChargeSearchRequest();
                                //request.set_created_at_from(new GregorianCalendar(2017, 5, 14).getTime()); // GregorianCalendar(year, month, date, hrs, min, sec) // month 0-11 not 1-12
                                //request.set_created_at_to(new GregorianCalendar(2017, 5, 16).getTime());
                                //request.set_created_at_to(new Date());
                                //request.set_gateway_id("58b60d8a6da7e425d6e4f6c7");

                              //new Charges().add(charge);
                                //new Charges().get(request);
                                //new Charges().get("595741d2e0beda7f78c3f05b");
                                //ChargeRefundResponse refund = new Charges().refund("5944d0708365e074bf46da37", new BigDecimal("10"));
                                //new Customers().get();


                               ExternalCheckoutRequest link = new ExternalCheckoutRequest();
                               link.set_gateway_id("58ede3577f8ce1233621d1bb");
                               link.set_mode("test");
                               link.set_success_redirect_url("http://success.com");
                               link.set_error_redirect_url("http://error.com");
                                ExternalCheckoutResponse response = new ExternalCheckout().create(link);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }).start();



                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
