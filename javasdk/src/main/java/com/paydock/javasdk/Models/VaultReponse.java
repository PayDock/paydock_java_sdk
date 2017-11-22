package com.paydock.javasdk.Models;


import java.util.Date;

public class VaultReponse extends Response
{
    public Resource resource;

    public static class Resource
    {
        public String type;
        public Data data;
    }

    public static class Data
    {
        public Date updated_at = null;
        public String vault_token;
        public String card_name;
        public int expire_month;
        public int expire_year;
        public String card_number_last4;
        public String card_scheme;
        public String status;
        public Date created_at = null;
        public String user_id;
        public String company_id;
        public String _source_ip_address;
        public String type;
    }

}
