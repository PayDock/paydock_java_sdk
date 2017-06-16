
package com.paydock.paydocksdk.Models;

import java.util.Date;

public class NotificationLogRequest   
{
    private String _id;
    public String get_id() {
        return _id;
    }
    public void set_id(String value) {
        _id = value;
    }

    private Boolean success;
    public Boolean get_success() {
        return success;
    }
    public void set_success(Boolean value) {
        success = value;
    }

    private String eventTrigger;
    public String get_eventTrigger() {
        return eventTrigger;
    }
    public void set_eventTrigger(String value) {
        eventTrigger = value;
    }

    private String type;
    public String get_type() {
        return type;
    }
    public void set_type(String value) {
        type = value;
    }

    private Date created_at_from;
    public Date get_created_at_from() {
        return created_at_from;
    }

    public void set_created_at_from(Date value) {
        created_at_from = value;
    }

    private Date created_at_to;
    public Date get_created_at_to() {
        return created_at_to;
    }

    public void set_created_at_to(Date value) {
        created_at_to = value;
    }

    private String parent_id;
    public String get_parent_id() {
        return parent_id;
    }

    public void set_parent_id(String value) {
        parent_id = value;
    }

    private String destination;
    public String get_destination() {
        return destination;
    }

    public void set_destination(String value) {
        destination = value;
    }

}


