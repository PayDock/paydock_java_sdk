
package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.*;

public interface INotifications
{
    NotificationTemplateResponse addTemplate(NotificationTemplateRequest request) throws Exception ;
    NotificationTriggerResponse addTrigger(NotificationTriggerRequest request) throws Exception ;
    NotificationTriggerResponse deleteLog(String notificationLogId) throws Exception ;
    NotificationTemplateResponse deleteTemplate(String notificationTemplateId) throws Exception ;
    NotificationTriggerResponse deleteTrigger(String notificationTriggerId) throws Exception ;
    NotificationLogsResponse getLogs(NotificationLogRequest request) throws Exception ;
    NotificationTriggerResponse getTrigger(String notificationTriggerId) throws Exception ;
    NotificationTriggerItemsResponse getTriggers() throws Exception ;
    NotificationTemplateResponse updateTemplate(NotificationTemplateUpdateRequest request) throws Exception ;
}


