
package com.paydock.paydocksdk.Tools;


import com.paydock.paydocksdk.Models.ErrorResponse;
import com.paydock.paydocksdk.Models.ResponseException;
import com.paydock.paydocksdk.Services.Config;
import com.paydock.paydocksdk.Tools.HttpMethod;
import com.paydock.paydocksdk.Tools.IServiceHelper;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
* Helper class to handle calling the API and basic serialisation
*/
public class ServiceHelper  implements IServiceHelper
{
//    static {
//        try
//        {
//            // set to TLS1.2
//            System.setProperty("https.protocols", "TLS1.2");
//        }
//        catch (Exception __dummyStaticConstructorCatchVar0)
//        {
//            throw new ExceptionInInitializerError(__dummyStaticConstructorCatchVar0);
//        }
//    }
//    /*
//    * Call the API, throws ResponseException on any errors
//    *
//    *  @param url relative URL to call (eg charge or notification/templates)
//    *  @param method HTTP method to call
//    *  @param json Data to send, will be ignored for some HTTP methods
//    *  @return the response string
//    */
    public String callPaydock(String endpoint, HttpMethod method, String json) throws Exception {
        String url = Config.baseUrl() + endpoint;
        URL obj = new URL(url);
        HttpURLConnection request = (HttpURLConnection) obj.openConnection();
        String test  = method.toString();
        request.setRequestMethod(test);
        request.setRequestProperty("content-type","application/json");
        request.setRequestProperty("x-user-secret-key", Config.getSecretKey());
        request.setUseCaches (false);



        if (method == HttpMethod.POST || method == HttpMethod.PUT)
        {
            request.setDoOutput(true);
            request.setRequestProperty("Content-Length","" + Integer.toString(json.getBytes().length));

            try
            {
                DataOutputStream wr = new DataOutputStream (request.getOutputStream());
                wr.writeBytes (json);
                wr.flush ();
                wr.close ();

            }catch (Exception ex) {
                return null;
            }

        }


        try
        {
            request.connect();
            int httpCode = request.getResponseCode();

            BufferedReader rd = null;

            if (httpCode == 200 || httpCode == 201)
            {
                rd = new BufferedReader(new InputStreamReader(request.getInputStream()));
            }
            else
            {
                rd = new BufferedReader(new InputStreamReader(request.getErrorStream()));
            }

            String line;
            StringBuffer response = new StringBuffer();

            while((line = rd.readLine()) != null) {
                response.append(line).append('\n');
            }
            rd.close();
            return response.toString();
        }
        catch (Exception ex)
        {
            //convertException(ex);
            return null;
        }
        finally
        {
            request.disconnect();
        }
    }

}


