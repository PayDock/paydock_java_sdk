package com.paydock.androidsdk.Tools;

import com.paydock.androidsdk.R;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Enclosed.class)
public class CardTypeTest {

    private static final String visa = "4242424242424242";
    private static final String master = "5555444433331111";
    private static final String amex = "378734493671000";
    private static final String diners = "38520000023237";
    private static final String discover = "6011111111111117";
    private static final String jcb = "3530111333300000";
    private static final String nocard = "1111111111111111";


    @RunWith(value = Parameterized.class)
    public static class CardTypeTestParameterized{

        //default value = 0
        @Parameterized.Parameter
        public String cardNumber;


        //Single parameter, use Object[]
        @Parameterized.Parameters(name = "Test Card Number - {0}")
        public static Object[] data() {
            return new Object[]{
                    visa,
                    master,
                    amex,
                    diners,
                    discover,
                    jcb
            };
        }

        @Test
        public void isValid() throws Exception {
            CardType test = CardType.getCreditCardTypeByNumber(cardNumber);
            Assert.assertTrue(test.isValid(cardNumber));
        }

    }


    public static class CardTypeTestNotParameterized{
        @Test
        public void getCreditCardTypeByNumber() throws Exception {
            CardType test = new CardType();
            Assert.assertTrue(test.getCardScheme() == R.string.btn_credit_card_default);
        }

        @Test
        public void getCardScheme() throws Exception {
            CardType test = new CardType();
            Assert.assertTrue(test.getCardScheme() == R.string.btn_credit_card_default);
        }

        @Test
        public void getImage() throws Exception {
            CardType test = new CardType();
            Assert.assertTrue(test.getImage() == R.drawable.ic_default);
        }

        @Test
        public void getMaxCardLength() throws Exception {
            CardType test = new CardType();
            Assert.assertTrue(test.getMaxCardLength() != 0);
        }

        @Test
        public void isValid() throws Exception {
            CardType test = CardType.getCreditCardTypeByNumber(nocard);
            Assert.assertFalse(test.isValid(nocard));
        }
    }

}