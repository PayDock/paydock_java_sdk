package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.NotificationTriggerData;
import com.paydock.paydocksdk.Models.Response;

public class NotificationTriggerResponse  extends Response 
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public NotificationTriggerData data;
    }
}


