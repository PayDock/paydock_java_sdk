
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.NotificationEvent;

public class NotificationTemplateUpdateRequest   
{
    private String _id;
    public String get_id() {
        return _id;
    }
    public void set_id(String value) {
        _id = value;
    }

    private String body;
    public String get_body() {
        return body;
    }
    public void set_body(String value) {
        body = value;
    }

    private String label;
    public String get_label() {
        return label;
    }
    public void set_label(String value) {
        label = value;
    }

    private NotificationEvent notification_event = NotificationEvent.transaction_success;
    public NotificationEvent get_notification_event() {
        return notification_event;
    }
    public void set_notification_event(NotificationEvent value) {
        notification_event = value;
    }

    private boolean html;
    public boolean get_html() {
        return html;
    }
    public void set_html(boolean value) {
        html = value;
    }

}


