package com.paydock.androidsdk.View;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.paydock.androidsdk.GetToken;
import com.paydock.androidsdk.IGetToken;
import com.paydock.androidsdk.Models.TokenCardResponse;
import com.paydock.androidsdk.R;
import com.paydock.androidsdk.Tools.CardType;
import com.paydock.androidsdk.Tools.DateHelper;
import com.paydock.javasdk.Models.PaymentType;
import com.paydock.javasdk.Models.TokenRequest;
import com.paydock.javasdk.Services.Environment;

@SuppressWarnings({"Convert2Lambda", "SameParameterValue"})
public class DirectDebitInputForm extends LinearLayout implements IDirectDebitInputForm {

    private static final String TAG = "DirectDebitInputForm";

    View rootView;

    private int[] spaceIndices = {3};

    private EditText etDirectDebitName;
    private EditText etDirectDebitBSBNumber;
    private EditText etDirectDebitAccountNumber;
    private TextInputLayout etDirectDebitNameLayout;
    private TextInputLayout etDirectDebitBSBNumberLayout;
    private TextInputLayout etDirectDebitAccountNumberLayout;
    private Resources mResources;

    public TokenCardResponse mTokenCardResponse;
    private String mGatewayID;
    
    public DirectDebitInputForm(Context context) {
        super(context);
        init(context);
    }

    public DirectDebitInputForm(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DirectDebitInputForm(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {

        rootView = inflate(context, R.layout.bank, this);

        etDirectDebitName = findViewById(R.id.etDirectDebitName);
        etDirectDebitBSBNumber = findViewById(R.id.etDirectDebitBSBNumber);
        etDirectDebitAccountNumber = findViewById(R.id.etDirectDebitAccountNumber);
        etDirectDebitNameLayout = findViewById(R.id.etDirectDebitNameLayout);
        etDirectDebitBSBNumberLayout = findViewById(R.id.etDirectDebitBSBNumberLayout);
        etDirectDebitAccountNumberLayout = findViewById(R.id.etDirectDebitAccountNumberLayout);

        mResources = getResources();
        
        mTokenCardResponse = new TokenCardResponse();

        etDirectDebitName.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean event) {
                if (!event) {
                    validateDirectDebitName(true);
                }
            }
        });

        etDirectDebitBSBNumber.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean event) {
                if (!event) {
                    validateDirectDebitBSBNumber(true);
                }
            }
        });

        etDirectDebitBSBNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                addTextSpan(s, spaceIndices, "-"); // span to seperate input text box
                if (validateDirectDebitBSBNumber(false)) {
                    etDirectDebitAccountNumber.requestFocus();
                }
            }
        });

        etDirectDebitAccountNumber.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean event) {
                if (!event) {
                    validateDirectDebitAccountNumber(true);
                }
            }
        });


        etDirectDebitAccountNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
//                if (validateDirectDebitAccountNumber(false)) {
//                }
            }
        });

    }


    private void addTextSpan(Editable s, int[] spaceIndices, String text) {
        Object[] paddingSpans = s.getSpans(0, s.length(), TextSpan.class);
        for (Object span : paddingSpans) {
            s.removeSpan(span);
        }
        for (int index : spaceIndices) {
            if (index <= s.length()) {
                s.setSpan(new TextSpan(text), index - 1, index,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }


    private String getDirectDebitName() {
        return etDirectDebitName.getText().toString();
    }

    private String getDirectDebitBSBNumber() {
        return etDirectDebitBSBNumber.getText().toString();
    }

    private String getDirectDebitAccountNumber() {
        return etDirectDebitAccountNumber.getText().toString();
    }

    private Boolean validateDirectDebitName(boolean showErrors)
    {
        if (getDirectDebitName().length() == 0) {
            if (showErrors)etDirectDebitName.setError(mResources.getString(R.string.btn_direct_debit_name_required));
            return false;
        } else {
            etDirectDebitNameLayout.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateDirectDebitBSBNumber(boolean showErrors)
    {
        String number = etDirectDebitBSBNumber.getText().toString();
        if (number.length() == 0) {
            if (showErrors)etDirectDebitBSBNumber.setError(mResources.getString(R.string.btn_direct_debit_bsb_number_required));
            return false;
        } else if (number.length() == 6){
            etDirectDebitBSBNumberLayout.setErrorEnabled(false);
            return true;
        } else {
            if (showErrors)etDirectDebitBSBNumber.setError(mResources.getString(R.string.btn_direct_debit_bsb_number_invalid));
            return false;
        }
    }

    private Boolean validateDirectDebitAccountNumber(boolean showErrors)
    {
        String AccountNumber = getDirectDebitAccountNumber();
        if (AccountNumber.length() == 0) {
            if (showErrors) etDirectDebitAccountNumber.setError(mResources.getString(R.string.btn_direct_debit_account_number_required));
            return false;
        }else if (AccountNumber.length() < 5) {
            if (showErrors) etDirectDebitAccountNumber.setError(mResources.getString(R.string.btn_direct_debit_account_number_invalid));
            return false;
        }else {
            etDirectDebitAccountNumberLayout.setErrorEnabled(false);
            return true;
        }
    }

    @Override
    public void getToken(Environment environment, String publicKey, String gatewayID, IGetToken delegateInterface) {
        mGatewayID = gatewayID;
        if (validate()){
            try {
                TokenRequest token = createToken();
                GetToken myTokenTask = new GetToken(environment, publicKey, delegateInterface, mTokenCardResponse);
                myTokenTask.execute(token);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Boolean validate()
    {
        boolean isValid = true;
        if(!validateDirectDebitAccountNumber(true)){
            etDirectDebitAccountNumberLayout.requestFocus();
            isValid = false;
        } else {
            String maskAccountNumber = getDirectDebitAccountNumber();
            mTokenCardResponse.account_number = maskAccountNumber.replaceAll("\\w(?=\\w{3})", "*");
        }
        if(!validateDirectDebitBSBNumber(true)){
            etDirectDebitBSBNumberLayout.requestFocus();
            isValid = false;
        } else {
            mTokenCardResponse.account_bsb = getDirectDebitBSBNumber();
        }
        if(!validateDirectDebitName(true)){
            etDirectDebitNameLayout.requestFocus();
            isValid = false;
        } else {
            mTokenCardResponse.account_name = getDirectDebitName();
        }
        return isValid;
    }

    @Override
    public void clear() {
        etDirectDebitName.setText("");
        etDirectDebitBSBNumber.setText("");
        etDirectDebitAccountNumber.setText("");
        etDirectDebitNameLayout.setErrorEnabled(false);
        etDirectDebitBSBNumberLayout.setErrorEnabled(false);
        etDirectDebitAccountNumberLayout.setErrorEnabled(false);
    }

    private TokenRequest createToken() {
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.gateway_id = mGatewayID;
        tokenRequest.type = PaymentType.bsb;
        tokenRequest.account_name = getDirectDebitName();
        tokenRequest.account_bsb = getDirectDebitBSBNumber();
        tokenRequest.account_number = getDirectDebitAccountNumber();
        return tokenRequest;
    }
}




