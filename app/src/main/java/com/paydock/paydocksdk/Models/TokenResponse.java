
package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.Response;

public class TokenResponse  extends Response 
{
    public Resource resource;

    public static class Resource   
    {
        public String type;
        public String data;
    }
}


