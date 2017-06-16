
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.NotificationTriggerData;
import com.paydock.paydocksdk.Models.Response;

public class NotificationTriggerItemsResponse  extends Response 
{
    private Resource resource;
    public Resource get_resource() {
        return resource;
    }
    public void set_resource(Resource value) {
        resource = value;
    }

    public static class Resource   
    {
        private String type;
        public String get_type() {
            return type;
        }
        public void set_type(String value) {
            type = value;
        }

        private int count;
        public int get_count() {
            return count;
        }
        public void set_count(int value) {
            count = value;
        }

        private int limit;
        public int get_limit() {
            return limit;
        }
        public void set_limit(int value) {
            limit = value;
        }

        private int skip;
        public int get_skip() {
            return skip;
        }
        public void set_skip(int value) {
            skip = value;
        }

        private NotificationTriggerData[] data;
        public NotificationTriggerData[] get_data() {
            return data;
        }
        public void set_data(NotificationTriggerData[] value) {
            data = value;
        }
    }

}


