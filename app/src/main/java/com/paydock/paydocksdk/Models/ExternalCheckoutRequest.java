
package com.paydock.paydocksdk.Models;


public class ExternalCheckoutRequest   
{
    private String mode;
    public String getmode() {
        return mode;
    }
    public void setmode(String value) {
        mode = value;
    }

    private String type;
    public String gettype() {
        return type;
    }
    public void settype(String value) {
        type = value;
    }

    private String gateway_id;
    public String getgateway_id() {
        return gateway_id;
    }
    public void setgateway_id(String value) {
        gateway_id = value;
    }

    private String success_redirect_url;
    public String getsuccess_redirect_url() {
        return success_redirect_url;
    }
    public void setsuccess_redirect_url(String value) {
        success_redirect_url = value;
    }

    private String error_redirect_url;
    public String geterror_redirect_url() {
        return error_redirect_url;
    }
    public void seterror_redirect_url(String value) {
        error_redirect_url = value;
    }

    private String description;
    public String getdescription() {
        return description;
    }
    public void setdescription(String value) {
        description = value;
    }
}


