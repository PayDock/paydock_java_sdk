
package com.paydock.javasdk.Models;

import java.util.Date;

public class NotificationLogResponse extends Response
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public Data data;
    }

    public static class Data
    {
        public Date created_at = null;
        public boolean success;
        public String type;
        public String destination;
        public String notification_id;
        public String parent_id;
        public String event;
        public String response_status;
        public String _id;
        public boolean archived;
    }

}


