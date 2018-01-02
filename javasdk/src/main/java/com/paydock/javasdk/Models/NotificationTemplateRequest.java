
package com.paydock.javasdk.Models;

public class NotificationTemplateRequest
{
    public String label;
    public String body;
    public NotificationEvent notification_event = NotificationEvent.transaction_success;
    public boolean html;
    public String destination;
    public String type;
}


