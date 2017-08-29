
package com.paydock.javasdk.Models;

public class NotificationTriggerItemsResponse  extends Response
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public int count;
        public int limit;
        public int skip;
        public NotificationTriggerData[] data;
    }

}


