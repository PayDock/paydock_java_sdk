
package com.paydock.javasdk.Models;

import java.util.Date;

public class NotificationLogSearchRequest
{
    public Boolean success;
    public String event;
    public String type;
    public Date created_at_from = null;
    public Date created_at_to = null;
    public String parent_id;
    public String destination;
}


