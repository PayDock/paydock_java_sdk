package com.paydock.paydocksdk.Models;

public class SubscriptionSearchRequest   
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

    private String search;
    public String get_search() {
        return search;
    }
    public void set_search(String value) {
        search = value;
    }

    private String sortkey;
    public String get_sortkey() {
        return sortkey;
    }
    public void set_sortkey(String value) {
        sortkey = value;
    }

    private String sortdirection;
    public String get_sortdirection() {
        return sortdirection;
    }
    public void set_sortdirection(String value) {
        sortdirection = value;
    }

    private String customer_id;
    public String get_customer_id() {
        return customer_id;
    }
    public void set_customer_id(String value) {
        customer_id = value;
    }

    private String gateway_id;
    public String get_gateway_id() {
        return gateway_id;
    }
    public void set_gateway_id(String value) {
        gateway_id = value;
    }

    private String status;
    public String get_status() {
        return status;
    }
    public void set_status(String value) {
        status = value;
    }
}


