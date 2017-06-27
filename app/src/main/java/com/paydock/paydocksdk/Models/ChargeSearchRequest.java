package com.paydock.paydocksdk.Models;

import java.util.Date;
import java.util.GregorianCalendar;

public class ChargeSearchRequest
{
    private Integer skip;
    public Integer get_skip() {
        return skip;
    }
    public void set_skip(Integer value) {
        skip = value;
    }

    private Integer limit;
    public Integer get_limit() {
        return limit;
    }
    public void set_limit(Integer value) {
        limit = value;
    }

    private String subscription_id;
    public String get_subscription_id() {
        return subscription_id;
    }
    public void set_subscription_id(String value) {
        subscription_id = value;
    }

    private String gateway_id;
    public String get_gateway_id() {
        return gateway_id;
    }
    public void set_gateway_id(String value) {
        gateway_id = value;
    }

    private String company_id;
    public String get_company_id() {
        return company_id;
    }
    public void set_company_id(String value) {
        company_id = value;
    }

    private Date created_at_from = null;// new GregorianCalendar(2000, 0, 1).getTime(); // Could be null
    public Date get_created_at_from() {
        return created_at_from;
    }
    public void set_created_at_from(Date value) { // Could be null
        created_at_from = value;
    }

    private Date created_at_to = null; //new Date(); // Could be null
    public Date get_created_at_to() {
        return created_at_to;
    }
    public void set_created_at_to(Date value) { // Could be null
        created_at_to = value;
    }

    private String search;
    public String get_search() {
        return search;
    }
    public void set_search(String value) {
        search = value;
    }

    private String status;
    public String get_status() {
        return status;
    }
    public void set_status(String value) {
        status = value;
    }

    private Boolean archived;
    public Boolean get_archived() {
        return archived;
    }
    public void set_archived(Boolean value) {
        archived = value;
    }

}


