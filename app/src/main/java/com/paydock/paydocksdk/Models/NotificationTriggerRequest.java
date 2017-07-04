
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.NotificationEvent;
import com.paydock.paydocksdk.Models.NotificationTriggerType;

public class NotificationTriggerRequest   
{
    public NotificationTriggerType type = NotificationTriggerType.webhook;
    public String destination;
    public String template_id;
    public NotificationEvent eventTrigger = NotificationEvent.transaction_success;
}


