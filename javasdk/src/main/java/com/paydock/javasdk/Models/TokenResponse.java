
package com.paydock.javasdk.Models;

public class TokenResponse  extends Response
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public String data;
    }
}


