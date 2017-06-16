
package com.paydock.paydocksdk.Models;

import java.math.BigDecimal;

public class ChargeRefundRequest
{
    private String id;
    public String get_id() {
        return id;
    }
    public void set_id(String value) {
        id = value;
    }

    private BigDecimal amount;
    public BigDecimal get_amount() {
        return amount;
    }
    public void set_amount(BigDecimal value) {
        amount = value;
    }

}


