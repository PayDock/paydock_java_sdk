
package com.paydock.javasdk.Models;

import java.util.Date;

public class NotificationLogsResponse  extends Response
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public Datum[] data;
        public int count;
        public int limit;
        public int skip;
        }

    public static class Datum   
    {
        public Date created_at = null;
        public boolean success;
        public String type;
        public String destination;
        public String notification_id;
        public String parent_id;
        public String _event;
        public String response_status;
        public String _id;
        public boolean archived;
    }

}


