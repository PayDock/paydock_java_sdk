
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

    public Notifications() throws Exception {
        _serviceHelper = new ServiceHelper();
    }

    public Notifications(IServiceHelper serviceHelper) throws Exception {
        _serviceHelper = serviceHelper;
    }

    public NotificationTemplateResponse addTemplate(NotificationTemplateRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("notifications/templates", HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTemplateResponse.class);
    }



    public NotificationTemplateResponse updateTemplate(NotificationTemplateUpdateRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("notifications/templates" + request.get_id(), HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTemplateResponse.class);
    }


    public NotificationTemplateResponse deleteTemplate(String notificationTemplateId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/templates/" + notificationTemplateId, HttpMethod.DELETE, "");
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTemplateResponse.class);
    }


    public NotificationTriggerResponse addTrigger(NotificationTriggerRequest request) throws Exception {
        String requestData = new Gson().toJson(request);
        String responseJson = _serviceHelper.callPaydock("notifications", HttpMethod.POST, requestData);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTriggerResponse.class);
    }


    public NotificationTriggerItemsResponse getTriggers() throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications", HttpMethod.GET, "");
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTriggerItemsResponse.class);
    }


    public NotificationTriggerResponse getTrigger(String notificationTriggerId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/" + notificationTriggerId, HttpMethod.GET, "");
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTriggerResponse.class);
    }


    public NotificationTriggerResponse deleteTrigger(String notificationTriggerId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/" + notificationTriggerId, HttpMethod.DELETE, "");
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTriggerResponse.class);
    }


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
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationLogsResponse.class);
    }


    public NotificationTriggerResponse deleteLog(String notificationLogId) throws Exception {
        String responseJson = _serviceHelper.callPaydock("notifications/logs/" + notificationLogId, HttpMethod.DELETE, "");
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(responseJson, NotificationTriggerResponse.class);
    }

}


