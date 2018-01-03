package com.paydock.javasdk.Services;


import com.paydock.javasdk.Models.NotificationEvent;
import com.paydock.javasdk.Models.NotificationLogResponse;
import com.paydock.javasdk.Models.NotificationLogSearchRequest;
import com.paydock.javasdk.Models.NotificationLogsResponse;
import com.paydock.javasdk.Models.NotificationTemplateRequest;
import com.paydock.javasdk.Models.NotificationTemplateResponse;
import com.paydock.javasdk.Models.NotificationTemplateUpdateRequest;
import com.paydock.javasdk.Models.NotificationTriggerItemsResponse;
import com.paydock.javasdk.Models.NotificationTriggerRequest;
import com.paydock.javasdk.Models.NotificationTriggerResponse;
import com.paydock.javasdk.Models.NotificationTriggerType;
import com.paydock.javasdk.PayDock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.Instant;
import java.util.Date;


@SuppressWarnings("SameParameterValue")
@RunWith(JUnit4.class)
public class NotificationsTest {

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, PayDock.SecretKey, PayDock.PublicKey);
    }

    private NotificationTemplateResponse add_template() throws Exception {
        NotificationTemplateRequest request = new NotificationTemplateRequest();
        request.body = "Charge {{CHARGE_ID}} with {{AMOUNT}} {{CURRENCY}} created.";
        request.label = "test_template";
        request.notification_event = NotificationEvent.transaction_success;
        request.html = false;
        return new Notifications().addTemplate(request);
    }

    private NotificationTriggerResponse add_notification_trigger(String templateID) throws Exception {
        NotificationTriggerRequest request = new NotificationTriggerRequest();
        request.type = NotificationTriggerType.webhook;
        request.destination = "https://www.paydock.com";
        request.template_id = templateID;
        request.event = NotificationEvent.transaction_success;
        return new Notifications().addTrigger(request);
    }

    private NotificationLogsResponse notification_log_search(NotificationLogSearchRequest request) throws Exception {
        request.success = true;
        request.event = "transaction_success";
        request.type = "https://www.paydock.com";
        request.created_at_from = Date.from(Instant.parse("2017-12-05T12:00:00Z"));
        request.created_at_to = Date.from(Instant.parse("2018-01-01T12:00:00Z"));

        return new Notifications().getLogs(request);
    }

    @Test
    public void addTemplate1() throws Exception {
        NotificationTemplateResponse response = add_template();
        Assert.assertTrue(response.get_IsSuccess());
    }

    @Test
    public void editTemplate1() throws Exception {
        NotificationTemplateResponse template = add_template();
        NotificationTemplateUpdateRequest request = new NotificationTemplateUpdateRequest();
        request._id = template.resource.data._id;
        request.body = "Charge {{CHARGE_ID}} with {{AMOUNT}} {{CURRENCY}} created.";
        request.label = "refund_failure";
        request.notification_event = NotificationEvent.transaction_success;
        request.html = false;
        NotificationTemplateResponse result = new Notifications().updateTemplate(request);
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void delete_template1() throws Exception {
        NotificationTemplateResponse template = add_template();
        NotificationTemplateResponse response = new Notifications().deleteTemplate(template.resource.data._id);
        Assert.assertTrue(response.get_IsSuccess());
    }

    @Test
    public void notification_trigger1() throws Exception {
        NotificationTemplateResponse template = add_template();
        NotificationTriggerResponse response = add_notification_trigger(template.resource.data._id);
        Assert.assertTrue(response.get_IsSuccess());
    }

    @Test
    public void get_notification_trigger_list() throws Exception {
        NotificationTriggerItemsResponse response = new Notifications().getTriggers();
        Assert.assertTrue(response.get_IsSuccess());
    }

    @Test
    public void get_notification_trigger_by_ID() throws Exception {
        NotificationTemplateResponse template = add_template();
        NotificationTriggerResponse result = add_notification_trigger(template.resource.data._id);
        NotificationTriggerResponse response = new Notifications().getTrigger(result.resource.data._id);
        Assert.assertTrue(response.get_IsSuccess());
    }

    @Test
    public void delete_notification_trigger() throws Exception {
        NotificationTemplateResponse template = add_template();
        NotificationTriggerResponse result = add_notification_trigger(template.resource.data._id);
        NotificationTriggerResponse response = new Notifications().deleteTrigger(result.resource.data._id);
        Assert.assertTrue(response.get_IsSuccess());
    }

    @Test
    public void get_user_notification_log() throws Exception
    {
        NotificationLogResponse response = new Notifications().getLog(PayDock.logId);
        Assert.assertTrue(response.get_IsSuccess());
    }


    @Test
    public void get_user_notification_log187() throws Exception {
        NotificationLogSearchRequest request = new NotificationLogSearchRequest();
            request.event = "transaction_success";
            request.success = true;
            request.type = "https://www.paydock.com";
            request.created_at_from = Date.from(Instant.parse("2018-01-01T12:00:00Z"));
            request.created_at_to = Date.from(Instant.parse("2018-01-03T12:00:00Z"));
        NotificationLogsResponse response = new Notifications().getLogs(request);
        Assert.assertTrue(response.get_IsSuccess());
    }

}