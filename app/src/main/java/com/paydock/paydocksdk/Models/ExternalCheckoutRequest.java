
package com.paydock.paydocksdk.Models;


public class ExternalCheckoutRequest   
{
    private String mode;
    public String get_mode() {
        return mode;
    }
    public void set_mode(String value) {
        mode = value;
    }

    private String gateway_id;
    public String get_gateway_id() {
        return gateway_id;
    }
    public void set_gateway_id(String value) {
        gateway_id = value;
    }

    private String success_redirect_url;
    public String get_success_redirect_url() {
        return success_redirect_url;
    }
    public void set_success_redirect_url(String value) {
        success_redirect_url = value;
    }

    private String error_redirect_url;
    public String get_error_redirect_url() {
        return error_redirect_url;
    }
    public void set_error_redirect_url(String value) {
        error_redirect_url = value;
    }

    private String description;
    public String get_description() {
        return description;
    }
    public void set_description(String value) {
        description = value;
    }

    private String checkout_token;
    public String get_checkout_token() {
        return checkout_token;
    }
    public void set_checkout_token(String value) {
        checkout_token = value;
    }

}


