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

import com.paydock.androidsdk.IGetToken;
import com.paydock.androidsdk.Models.TokenCardResponse;
import com.paydock.androidsdk.Tools.DateHelper;
import com.paydock.androidsdk.Tools.CardType;
import com.paydock.androidsdk.R;
import com.paydock.androidsdk.GetToken;
import com.paydock.javasdk.Models.TokenRequest;
import com.paydock.javasdk.Services.Environment;

@SuppressWarnings({"Convert2Lambda", "SameParameterValue"})
public class CreditCardInputForm extends LinearLayout implements ICreditCardInputForm {

    private static final String TAG = "CardInputForm";

    View rootView;

    private static final int[] NORMAL_CARD_SPACES = { 4, 8, 12 };
    private static final int[] SHORT_CARD_SPACES = { 4, 10 };
    private static final int[] DATE_SPACES = { 2 };

    private int[] spaceIndices = NORMAL_CARD_SPACES;

    private EditText etCreditCardName;
    private EditText etCreditCardNumber;
    private EditText etCreditCardExpiry;
    private EditText etCreditCardCVC;
    private TextInputLayout etCreditCardNameLayout;
    private TextInputLayout etCreditCardNumberLayout;
    private TextInputLayout etCreditCardExpiryLayout;
    private TextInputLayout etCreditCardCVCLayout;
    private Resources mResources;
    private ImageView ivCreditCardIcons;

    public TokenCardResponse mTokenCardResponse;
    private String mGatewayID;

    protected CardType mCardType;

    public CreditCardInputForm(Context context) {
        super(context);
        init(context);
    }

    public CreditCardInputForm(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CreditCardInputForm(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {

        rootView = inflate(context, R.layout.credit_card, this);

        etCreditCardName = findViewById(R.id.etCreditCardName);
        etCreditCardNumber = findViewById(R.id.etCreditCardNumber);
        etCreditCardExpiry = findViewById(R.id.etCreditCardExpiry);
        etCreditCardCVC = findViewById(R.id.etCreditCardCVC);
        ivCreditCardIcons = findViewById(R.id.ivCreditCardIcon);
        etCreditCardNameLayout = findViewById(R.id.etCreditCardNameLayout);
        etCreditCardNumberLayout = findViewById(R.id.etCreditCardNumberLayout);
        etCreditCardExpiryLayout = findViewById(R.id.etCreditCardExpiryLayout);
        etCreditCardCVCLayout = findViewById(R.id.etCreditCardCVCLayout);

        mResources = getResources();

        mCardType = new CardType();
        mTokenCardResponse = new TokenCardResponse();

        etCreditCardName.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean event) {
                if (!event) {
                    CreditCardInputForm.this.validateCreditCardName(true);
                }
            }
        });

        etCreditCardNumber.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean event) {
                if (!event) {
                    CreditCardInputForm.this.validateCreditCardNumber(true);
                }
            }
        });

        etCreditCardNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                addTextSpan(s, spaceIndices, " "); // span to seperate input text box
                updateCardType();
                if (validateCreditCardNumber(false)) {
                    etCreditCardExpiry.requestFocus();
                }
            }
        });

        etCreditCardExpiry.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean event) {
                etCreditCardExpiry.setHint(R.string.btn_credit_card_expiry_hint);
                if (!event) {
                    etCreditCardExpiry.setHint("");
                    validateCreditCardExpiry(true);
                }
            }
        });


        etCreditCardExpiry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                addTextSpan(s, DATE_SPACES, "/");
                if (validateCreditCardExpiry(false)) {
                    etCreditCardCVC.requestFocus();
                }
            }
        });

        etCreditCardCVC.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean event) {
                if (!event) {
                    CreditCardInputForm.this.validateCreditCardCVC(true);
                }
            }
        });

    }

    private void updateCardType() {
        try {
            CardType cardType = CardType.getCreditCardTypeByNumber(getCreditCardNumber());
            assert cardType != null;
            if ((mCardType == null) || (mResources.getString(mCardType.getCardScheme()) !=
                    mResources.getString(cardType.getCardScheme()))){
                mCardType = cardType;
                ivCreditCardIcons.setImageResource(mCardType.getImage());

                if (mCardType.getMaxCardLength() == 15) {
                    spaceIndices = SHORT_CARD_SPACES;
                    InputFilter[] filterCVCLength = {new InputFilter.LengthFilter(4)};
                    etCreditCardCVC.setFilters(filterCVCLength);
                } else {
                    spaceIndices = NORMAL_CARD_SPACES;
                    InputFilter[] filterCVCLength = {new InputFilter.LengthFilter(3)};
                    etCreditCardCVC.setFilters(filterCVCLength);
                }

                InputFilter[] filterMaxDigits = {new InputFilter.LengthFilter(mCardType.getMaxCardLength())};
                etCreditCardNumber.setFilters(filterMaxDigits);

                invalidate();
            }
        }catch (NullPointerException e){
                Log.e(TAG, "updateCardType: ", e);
            }
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


    private String getCreditCardName() {
        return etCreditCardName.getText().toString();
    }

    private String getCreditCardNumber() {
        return etCreditCardNumber.getText().toString();
    }

    private String getCreditCardExpiryMonth() {
        String mDateMonth = etCreditCardExpiry.getText().toString();
        mDateMonth = mDateMonth.substring(0, 2);
        return mDateMonth;
    }

    private String getCreditCardExpiryYear() {
        String mDateYear = etCreditCardExpiry.getText().toString();
        mDateYear = "20" + mDateYear.substring(2, 4);
        return mDateYear;
    }

    private String getCreditCardCVC() {
        return etCreditCardCVC.getText().toString();
    }

    private Boolean validateCreditCardName(boolean showErrors)
    {
        if (getCreditCardName().length() == 0) {
            if (showErrors)etCreditCardName.setError(mResources.getString(R.string.btn_credit_card_name_required));
            return false;
        } else {
            etCreditCardExpiryLayout.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateCreditCardNumber(boolean showErrors)
    {
        String number = etCreditCardNumber.getText().toString();
        if (number.length() == 0) {
            if (showErrors)etCreditCardNumber.setError(mResources.getString(R.string.btn_credit_card_number_required));
            return false;
        } else if (mCardType == null){
            if (showErrors)etCreditCardNumber.setError(mResources.getString(R.string.btn_credit_card_number_required));
            return false;
        } else if (mCardType.isValid(getCreditCardNumber())) {
            etCreditCardNumberLayout.setErrorEnabled(false);
            return true;
        } else {
            if (showErrors)etCreditCardNumber.setError(mResources.getString(R.string.btn_credit_card_number_invalid));
            return false;
        }
    }


    private Boolean validateCreditCardExpiry(boolean showErrors)
    {
        String date = etCreditCardExpiry.getText().toString();
        if (date.length() == 0) {
            if (showErrors)etCreditCardExpiry.setError(mResources.getString(R.string.btn_credit_card_expiry_required));
            return false;
        } else if (date.length() < 4) {
            if (showErrors)etCreditCardExpiry.setError(mResources.getString(R.string.btn_credit_card_expiry_invalid));
            return false;
        } else if (date.length() == 4) {
            boolean dateValid = DateHelper.isFuture(date.substring(0, 2), date.substring(2, 4));
            if (dateValid) {
                etCreditCardExpiryLayout.setErrorEnabled(false);
                return true;
            } else {
                if (showErrors)etCreditCardExpiry.setError(mResources.getString(R.string.btn_credit_card_expiry_invalid));
                return false;
            }
        }
        return false;
    }

    private Boolean validateCreditCardCVC(boolean showErrors)
    {
        String CVC = getCreditCardCVC();
        if (CVC.length() != 0) {
            if ((mCardType.getMaxCardLength() == 15) && (CVC.length() == 4)) {
                etCreditCardCVCLayout.setErrorEnabled(false);
                return true;
            } else if (!(mCardType.getMaxCardLength() == 15) && (CVC.length() == 3)) {
                etCreditCardCVCLayout.setErrorEnabled(false);
                return true;
            } else {
                if (showErrors) etCreditCardCVC.setError(mResources.getString(R.string.btn_credit_card_cvc_invalid));
                return false;
            }
        }else {
            etCreditCardCVCLayout.setErrorEnabled(false);
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
        if(!validateCreditCardCVC(true)){
            etCreditCardCVCLayout.requestFocus();
            isValid = false;
        }
        if(!validateCreditCardExpiry(true)){
            etCreditCardExpiryLayout.requestFocus();
            isValid = false;
        } else {
            mTokenCardResponse.expiry_month = getCreditCardExpiryMonth();
            mTokenCardResponse.expiry_year = getCreditCardExpiryYear();
        }
        if(!validateCreditCardNumber(true)){
            etCreditCardNumberLayout.requestFocus();
            isValid = false;
        } else {
            String creditCardNumber = getCreditCardNumber();
            int creditCardNumberLength = creditCardNumber.length();
            if (creditCardNumberLength >= 4) {
                mTokenCardResponse.card_number_last4 = (creditCardNumber.substring
                        (creditCardNumberLength - 4, creditCardNumberLength));
                mTokenCardResponse.card_scheme = mResources.getString(mCardType.getCardScheme());
            } else {
                mTokenCardResponse.card_number_last4 = "";
            }
        }
        if(!validateCreditCardName(true)){
            etCreditCardNameLayout.requestFocus();
            isValid = false;
        } else {
            mTokenCardResponse.card_name = getCreditCardName();
        }
        return isValid;
    }

    @Override
    public void clear() {
        etCreditCardName.setText("");
        etCreditCardNumber.setText("");
        etCreditCardExpiry.setText("");
        etCreditCardCVC.setText("");
        etCreditCardNameLayout.setErrorEnabled(false);
        etCreditCardNumberLayout.setErrorEnabled(false);
        etCreditCardExpiryLayout.setErrorEnabled(false);
        etCreditCardCVCLayout.setErrorEnabled(false);
    }

    private TokenRequest createToken() {
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.gateway_id = mGatewayID;
        tokenRequest.card_name = getCreditCardName();
        tokenRequest.card_number = getCreditCardNumber();
        tokenRequest.expire_month = getCreditCardExpiryMonth();
        tokenRequest.expire_year = getCreditCardExpiryYear();
        tokenRequest.card_ccv = getCreditCardCVC();
        return tokenRequest;
    }
}




