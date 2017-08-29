package com.paydock.javasdk.Models;

public class NotificationTriggerResponse  extends Response
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public NotificationTriggerData data;
    }
}


