
package com.paydock.javasdk.Models;


abstract class ExternalCheckoutRequestBase
{
    public String mode;
    public String gateway_id;
    public String success_redirect_url;
    public String error_redirect_url;
    public String description;
    public String checkout_token;
}


