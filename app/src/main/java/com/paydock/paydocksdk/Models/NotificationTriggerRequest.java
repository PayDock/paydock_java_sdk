
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.NotificationEvent;
import com.paydock.paydocksdk.Models.NotificationTriggerType;

public class NotificationTriggerRequest   
{
    private NotificationTriggerType type = NotificationTriggerType.webhook;
    public NotificationTriggerType get_type() {
        return type;
    }
    public void set_type(NotificationTriggerType value) {
        type = value;
    }

    private String destination;
    public String get_destination() {
        return destination;
    }
    public void set_destination(String value) {
        destination = value;
    }

    private String template_id;
    public String get_template_id() {
        return template_id;
    }
    public void set_template_id(String value) {
        template_id = value;
    }

    private NotificationEvent eventTrigger = NotificationEvent.transaction_success;
    public NotificationEvent get_eventTrigger() {
        return eventTrigger;
    }
    public void set_eventTrigger(NotificationEvent value) {
        eventTrigger = value;
    }

}


