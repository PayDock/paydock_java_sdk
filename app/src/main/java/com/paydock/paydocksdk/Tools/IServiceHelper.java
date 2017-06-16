
package com.paydock.paydocksdk.Tools;

import com.paydock.paydocksdk.Tools.HttpMethod;

public interface IServiceHelper   
{
    String callPaydock(String endpoint, HttpMethod method, String json) throws Exception ;

}


