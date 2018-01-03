
package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.NotificationLogResponse;
import com.paydock.javasdk.Models.NotificationLogSearchRequest;
import com.paydock.javasdk.Models.NotificationLogsResponse;
import com.paydock.javasdk.Models.NotificationTemplateRequest;
import com.paydock.javasdk.Models.NotificationTemplateResponse;
import com.paydock.javasdk.Models.NotificationTemplateUpdateRequest;
import com.paydock.javasdk.Models.NotificationTemplatesResponse;
import com.paydock.javasdk.Models.NotificationTriggerItemsResponse;
import com.paydock.javasdk.Models.NotificationTriggerRequest;
import com.paydock.javasdk.Models.NotificationTriggerResponse;

public interface INotifications
{
    NotificationTemplateResponse addTemplate(NotificationTemplateRequest request) throws Exception ;
    NotificationTriggerResponse addTrigger(NotificationTriggerRequest request) throws Exception ;
    NotificationTriggerResponse deleteLog(String notificationLogId) throws Exception ;
    NotificationTemplateResponse deleteTemplate(String notificationTemplateId) throws Exception ;
    NotificationTriggerResponse deleteTrigger(String notificationTriggerId) throws Exception ;
    NotificationLogResponse getLog(String logId) throws Exception ;
    NotificationLogsResponse getLogs(NotificationLogSearchRequest request) throws Exception ;
    NotificationTriggerResponse getTrigger(String notificationTriggerId) throws Exception ;
    NotificationTriggerItemsResponse getTriggers() throws Exception ;
    NotificationTemplatesResponse getNotifications() throws Exception ;
    NotificationTemplateResponse getNotification(String notificationId) throws Exception ;
    NotificationTemplateResponse updateTemplate(NotificationTemplateUpdateRequest request) throws Exception ;
}


