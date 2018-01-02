
package com.paydock.javasdk.Models;

public class NotificationTriggerRequest
{
    public NotificationTriggerType type = NotificationTriggerType.webhook;
    public String destination;
    public String template_id;
    public NotificationEvent event = NotificationEvent.transaction_success;
}


