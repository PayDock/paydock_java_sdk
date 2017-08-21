package com.paydock.androidsdk.Tools;

import com.paydock.androidsdk.R;


public class CardType {

    private final int mCardScheme;
    private final int mImageResource;
    private final int mMinCardLength;
    private final int mMaxCardLength;

    private CardType(int cardScheme, int imageResource, int minCardLength, int maxCardLength) {
        mCardScheme = cardScheme;
        mImageResource = imageResource;
        mMinCardLength = minCardLength;
        mMaxCardLength = maxCardLength;
    }

    public CardType(){
        mCardScheme = R.string.btn_credit_card_default;
        mImageResource = R.drawable.ic_default;
        mMinCardLength = 16;
        mMaxCardLength = 16;
    }


    public static CardType getCreditCardTypeByNumber(String creditCardNumber) {

        final String regexVisa = "^4\\d*";
        final String regexMaster = "^(222[1-9]|22[3-9]|2[3-6]|27[0-1]|2720|5[1-5])\\d*";
        final String regexAMEX = "^3[47]\\d*";
        final String regexDiners = "^(30[0-5]|309|36|3[8-9])\\d*";
        final String regexCUP= "^62\\d*";

        if(creditCardNumber.matches(regexVisa))
            return new CardType(R.string.btn_credit_card_visa, R.drawable.ic_visa, 16, 16);
        if (creditCardNumber.matches(regexMaster))
            return new CardType(R.string.btn_credit_card_mastercard, R.drawable.ic_mastercard, 16, 16);
        if (creditCardNumber.matches(regexAMEX))
            return new CardType(R.string.btn_credit_card_amex, R.drawable.ic_amex, 15, 15);
        if (creditCardNumber.matches(regexDiners))
            return new CardType(R.string.btn_credit_card_diners, R.drawable.ic_diners, 14, 19);
        if (creditCardNumber.matches(regexCUP))
            return new CardType(R.string.btn_credit_card_cup, R.drawable.ic_cup, 16, 19);

        return new CardType(R.string.btn_credit_card_default, R.drawable.ic_default, 16, 16);

    }

    public int getCardScheme() {
        return mCardScheme;
    }

    public int getImage() {
        return mImageResource;
    }

    public int getMaxCardLength() {
        return mMaxCardLength;
    }

    public boolean isValid(String cardNumber) {

        if ((cardNumber.length() == 0) || (cardNumber.length() < mMinCardLength) ||
                (cardNumber.length() > mMaxCardLength)){
           return false;
        }

        final String reversed = new StringBuffer(cardNumber).reverse().toString();
        final int len = reversed.length();
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < len; i++) {
            final char c = reversed.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(String.format("Not a digit: '%s'", c));
            }
            final int digit = Character.digit(c, 10);
            if (i % 2 == 0) {
                oddSum += digit;
            } else {
                evenSum += digit / 5 + (2 * digit) % 10;
            }
        }
        return (oddSum + evenSum) % 10 == 0;
    }


}
