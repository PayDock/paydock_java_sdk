
package com.paydock.javasdk.Models;

public class NotificationTemplateRequest
{
    public String body;
    public String label;
    public NotificationEvent notification_event = NotificationEvent.transaction_success;
    public boolean html;
}


