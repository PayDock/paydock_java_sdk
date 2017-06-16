
package com.paydock.paydocksdk.Models;

import java.util.Date;
import com.paydock.paydocksdk.Models.Response;

public class NotificationLogsResponse  extends Response 
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

        private Datum[] data;
        public Datum[] get_data() {
            return data;
        }
        public void set_data(Datum[] value) {
            data = value;
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
    }

    public static class Datum   
    {
        private Date created_at;
        public Date get_created_at() {
            return created_at;
        }
        public void set_created_at(Date value) {
            created_at = value;
        }

        private boolean success;
        public boolean get_success() {
            return success;
        }
        public void set_success(boolean value) {
            success = value;
        }

        private String type;
        public String get_type() {
            return type;
        }
        public void set_type(String value) {
            type = value;
        }

        private String destination;
        public String get_destination() {
            return destination;
        }
        public void set_destination(String value) {
            destination = value;
        }

        private String notification_id;
        public String get_notification_id() {
            return notification_id;
        }
        public void set_notification_id(String value) {
            notification_id = value;
        }

        private String parent_id;
        public String get_parent_id() {
            return parent_id;
        }
        public void set_parent_id(String value) {
            parent_id = value;
        }

        private String _event;
        public String get__event() {
            return _event;
        }
        public void set__event(String value) {
            _event = value;
        }

        private String response_status;
        public String get_response_status() {
            return response_status;
        }
        public void set_response_status(String value) {
            response_status = value;
        }

        private String _id;
        public String get_id() {
            return _id;
        }
        public void set_id(String value) {
            _id = value;
        }

        private boolean archived;
        public boolean get_archived() {
            return archived;
        }
        public void set_archived(boolean value) {
            archived = value;
        }
    }

}


