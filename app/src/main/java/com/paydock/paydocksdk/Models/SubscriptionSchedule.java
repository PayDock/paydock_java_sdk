
package com.paydock.paydocksdk.Models;

import java.math.BigDecimal;
import java.util.Date;

public class SubscriptionSchedule   
{
    private String interval;
    public String get_interval() {
        return interval;
    }
    public void set_interval(String value) {
        interval = value;
    }

    private int frequency;
    public int get_frequency() {
        return frequency;
    }
    public void set_frequency(int value) {
        frequency = value;
    }

    private Date start_date = null; //new GregorianCalendar(2000, 0, 1).getTime();
    public Date get_start_date() {
        return start_date;
    }
    public void set_start_date(Date value) {
        start_date = value;
    }

    private Date end_date = null; //new GregorianCalendar(2030, 0, 1).getTime();
    public Date get_end_date() {
        return end_date;
    }
    public void set_end_date(Date value) {
        end_date = value;
    }

    private BigDecimal end_amount_after;
    public BigDecimal get_end_amount_after() {
        return end_amount_after;
    }
    public void set_end_amount_after(BigDecimal value) {
        end_amount_after = value;
    }

    private BigDecimal end_amount_before;
    public BigDecimal get_end_amount_before() {
        return end_amount_before;
    }
    public void set_end_amount_before(BigDecimal value) {
        end_amount_before = value;
    }

    private Integer end_transactions;
    public Integer get_end_transactions() {
        return end_transactions;
    }
    public void set_end_transactions(Integer value) {
        end_transactions = value;
    }
}


