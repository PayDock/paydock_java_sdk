package com.paydock.paydocksdk.Models;

import java.util.Date;

public class ChargeSearchRequest
{
    public Integer skip;
    public Integer limit;
    public String subscription_id;
    public String gateway_id;
    public String company_id;
    public Date created_at_from = null;
    public Date created_at_to = null;
    public String search;
    public String status;
    public Boolean archived;
}


