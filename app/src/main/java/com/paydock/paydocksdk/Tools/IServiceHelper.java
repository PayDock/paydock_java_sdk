
package com.paydock.paydocksdk.Tools;

public interface IServiceHelper   
{
    String callPaydock(String endpoint, HttpMethod method, String json) throws Exception ;
}


