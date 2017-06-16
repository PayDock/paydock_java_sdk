
package com.paydock.paydocksdk.Models;

import java.util.Date;
import com.paydock.paydocksdk.Models.Response;

public class NotificationTemplateResponse  extends Response 
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

        private Data data;
        public Data get_data() {
            return data;
        }
        public void set_data(Data value) {
            data = value;
        }
    }

    public static class Data   
    {
        private int __v;
        public int get_v() {
            return __v;
        }
        public void set_v(int value) {
            __v = value;
        }

        private Date created_at;
        public Date get_created_at() {
            return created_at;
        }
        public void set_created_at(Date value) {
            created_at = value;
        }

        private Date updated_at;
        public Date get_updated_at() {
            return updated_at;
        }
        public void set_updated_at(Date value) {
            updated_at = value;
        }

        private String label;
        public String get_label() {
            return label;
        }
        public void set_label(String value) {
            label = value;
        }

        private String notification_event;
        public String get_notification_event() {
            return notification_event;
        }
        public void set_notification_event(String value) {
            notification_event = value;
        }

        private String body;
        public String get_body() {
            return body;
        }
        public void set_body(String value) {
            body = value;
        }

        private String _id;
        public String get_id() {
            return _id;
        }
        public void set_id(String value) {
            _id = value;
        }
    }

}


