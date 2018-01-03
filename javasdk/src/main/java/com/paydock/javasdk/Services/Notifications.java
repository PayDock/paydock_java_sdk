
package com.paydock.javasdk.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import com.paydock.javasdk.Tools.HttpMethod;
import com.paydock.javasdk.Tools.IServiceHelper;
import com.paydock.javasdk.Tools.ServiceHelper;
import com.paydock.javasdk.Tools.UrlExtensionMethods;

public class Notifications implements INotifications
{
    protected IServiceHelper _serviceHelper;// = new IServiceHelper();

    public Notifications() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    public Notifications(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    public NotificationTemplateResponse addTemplate(NotificationTemplateRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("notifications/templates", HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTemplateResponse.class);
    }

    public NotificationTemplatesResponse getNotifications() throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/templates", HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTemplatesResponse.class);
    }

    public NotificationTemplateResponse getNotification(String notificationId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/templates/" + notificationId, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTemplateResponse.class);
    }


    public NotificationTemplateResponse updateTemplate(NotificationTemplateUpdateRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("notifications/templates/" + request._id, HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTemplateResponse.class);
    }


    public NotificationTemplateResponse deleteTemplate(String notificationTemplateId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/templates/" + notificationTemplateId, HttpMethod.DELETE, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTemplateResponse.class);
    }


    public NotificationTriggerResponse addTrigger(NotificationTriggerRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("notifications", HttpMethod.POST, requestData, false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTriggerResponse.class);
    }


    public NotificationTriggerItemsResponse getTriggers() throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications", HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTriggerItemsResponse.class);
    }


    public NotificationTriggerResponse getTrigger(String notificationTriggerId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/" + notificationTriggerId, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTriggerResponse.class);
    }


    public NotificationTriggerResponse deleteTrigger(String notificationTriggerId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/" + notificationTriggerId, HttpMethod.DELETE, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTriggerResponse.class);
    }

    public NotificationLogResponse getLog(String logId) throws Exception {
        String url = "notifications/logs/";
        url = UrlExtensionMethods.appendParameter(url, "_id", logId);
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationLogResponse.class);
    }

    public NotificationLogsResponse getLogs(NotificationLogSearchRequest request) throws Exception {
        String url = "notifications/logs/";
        url = UrlExtensionMethods.appendParameter(url, "success", request.success);
        url = UrlExtensionMethods.appendParameter(url, "event", request.event);
        url = UrlExtensionMethods.appendParameter(url, "type", request.type);
        url = UrlExtensionMethods.appendParameter(url, "created_at.from", request.created_at_from);
        url = UrlExtensionMethods.appendParameter(url, "created_at.to", request.created_at_to);
        url = UrlExtensionMethods.appendParameter(url, "parent_id", request.parent_id);
        url = UrlExtensionMethods.appendParameter(url, "destination", request.destination);
        String responseJson = _serviceHelper.callPaydock(url, HttpMethod.GET, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationLogsResponse.class);
    }


    public NotificationTriggerResponse deleteLog(String notificationLogId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/logs/" + notificationLogId, HttpMethod.DELETE, "", false);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTriggerResponse.class);
    }

}


