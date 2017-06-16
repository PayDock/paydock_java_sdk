
package com.paydock.paydocksdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paydock.paydocksdk.Models.*;
import com.paydock.paydocksdk.Services.INotifications;
import com.paydock.paydocksdk.Tools.*;

import static com.paydock.paydocksdk.Tools.UrlExtensionMethods.appendParameter;

public class Notifications implements INotifications
{
    protected IServiceHelper _serviceHelper;// = new IServiceHelper();
    /**
    * Service locator style constructor
    */
    public Notifications() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    /**
    * Dependency injection constructor to enable testing
    */
    public Notifications(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    /**
    * Add notification template
    * 
    *  @param request Notification template data
    *  @return Created notification
    */
    public NotificationTemplateResponse addTemplate(NotificationTemplateRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("notifications/templates", HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        NotificationTemplateResponse response = gson.fromJson(responseJson, NotificationTemplateResponse.class);
        return response;
    }


    /**
    * Update notification template
    * 
    *  @param request Notification template data
    *  @return Updated notification
    */
    public NotificationTemplateResponse updateTemplate(NotificationTemplateUpdateRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("notifications/templates" + request.get_id(), HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        NotificationTemplateResponse response = gson.fromJson(responseJson, NotificationTemplateResponse.class);
        return response;
    }

    /**
    * Delete a notification template
    * 
    *  @param //subscriptionId id of the notification template
    *  @return information on the notification template
    */
    public NotificationTemplateResponse deleteTemplate(String notificationTemplateId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/templates/" + notificationTemplateId, HttpMethod.DELETE, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        NotificationTemplateResponse response = gson.fromJson(responseJson, NotificationTemplateResponse.class);
        return response;
    }

    /**
    * Creates a notification trigger
    * 
    *  @param request data to create the trigger
    *  @return the created notification trigger
    */
    public NotificationTriggerResponse addTrigger(NotificationTriggerRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("notifications", HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        NotificationTriggerResponse response = gson.fromJson(responseJson, NotificationTriggerResponse.class);
        return response;
    }

    /**
    * returns all notification triggers, limited to 1000
    * 
    *  @return notification triggers
    */
    public NotificationTriggerItemsResponse getTriggers() throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications", HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        NotificationTriggerItemsResponse response = gson.fromJson(responseJson, NotificationTriggerItemsResponse.class);
        return response;
    }

    /**
    * returns a single notification trigger
    * 
    *  @param notificationTriggerId id for the trigger
    *  @return notification trigger
    */
    public NotificationTriggerResponse getTrigger(String notificationTriggerId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/" + notificationTriggerId, HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        NotificationTriggerResponse response = gson.fromJson(responseJson, NotificationTriggerResponse.class);
        return response;
    }

    /**
    * deletes a notification trigger
    * 
    *  @param notificationTriggerId id for the trigger
    *  @return notification trigger
    */
    public NotificationTriggerResponse deleteTrigger(String notificationTriggerId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/" + notificationTriggerId, HttpMethod.DELETE, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        NotificationTriggerResponse response = gson.fromJson(responseJson, NotificationTriggerResponse.class);
        return response;
    }

    /**
    * gets notification logs
    * 
    *  @param request data for the trigger
    *  @return notification logs
    */
    public NotificationLogsResponse getLogs(NotificationLogRequest request) throws Exception {
        String url = "notifications/logs/";
        url = appendParameter(url, "_id", request.get_id());
        url = appendParameter(url, "success", request.get_success());
        url = appendParameter(url, "event", request.get_eventTrigger());
        url = appendParameter(url, "type", request.get_type());
        url = appendParameter(url, "created_at.from", request.get_created_at_from());
        url = appendParameter(url, "created_at.to", request.get_created_at_to());
        url = appendParameter(url, "parent_id", request.get_parent_id());
        url = appendParameter(url, "destination", request.get_destination());
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        NotificationLogsResponse response = gson.fromJson(responseJson, NotificationLogsResponse.class);
        return response;
    }

    /**
    * deletes a notification trigger
    * 
    *  @param //notificationTriggerId id for the trigger
    *  @return notification trigger
    */
    public NotificationTriggerResponse deleteLog(String notificationLogId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/logs/" + notificationLogId, HttpMethod.DELETE, "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        NotificationTriggerResponse response = gson.fromJson(responseJson, NotificationTriggerResponse.class);
        return response;
    }

}


