
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.NotificationTriggerData;
import com.paydock.paydocksdk.Models.Response;

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


