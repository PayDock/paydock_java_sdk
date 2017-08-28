
package com.paydock.javasdk.Models;

import java.util.Date;

public class NotificationLogRequest   
{
    public String _id;
    public Boolean success;
    public String eventTrigger;
    public String type;
    public Date created_at_from = null;
    public Date created_at_to = null;
    public String parent_id;
    public String destination;
    }


