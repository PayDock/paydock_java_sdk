
package com.paydock.javasdk.Models;

import java.util.Date;

public class NotificationTemplateResponse  extends Response
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public Data data;
    }

    public static class Data   
    {
        public int __v;
        public Date created_at;
        public Date updated_at;
        public String label;
        public String notification_event;
        public String body;
        public String _id;
    }

}


