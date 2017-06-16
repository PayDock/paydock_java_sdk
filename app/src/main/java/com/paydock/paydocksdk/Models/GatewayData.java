package com.paydock.paydocksdk.Models;

import java.util.Date;

public class GatewayData   
{
    private Date created_at;
    public Date get_created_at() {
        return created_at;
    }
    public void set_created_at(Date value) {
        created_at = value;
    }

    private Date updated_at;
    public Date get_updated_at() {
        return updated_at;
    }
    public void set_updated_at(Date value) {
        updated_at = value;
    }

    private String type;
    public String get_type() {
        return type;
    }
    public void set_type(String value) {
        type = value;
    }

    private String name;
    public String get_name() {
        return name;
    }
    public void set_name(String value) {
        name = value;
    }

    private String username;
    public String get_username() {
        return username;
    }
    public void set_username(String value) {
        username = value;
    }

    private String password;
    public String get_password() {
        return password;
    }
    public void set_password(String value) {
        password = value;
    }

    private String _id;
    public String get_id() {
        return _id;
    }
    public void set_id(String value) {
        _id = value;
    }

    private String mode;
    public String get_mode() {
        return mode;
    }
    public void set_mode(String value) {
        mode = value;
    }

    private int active_subscriptions;
    public int get_active_subscriptions() {
        return active_subscriptions;
    }
    public void set_active_subscriptions(int value) {
        active_subscriptions = value;
    }
}


