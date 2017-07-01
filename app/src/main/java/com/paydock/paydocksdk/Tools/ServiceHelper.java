
package com.paydock.paydocksdk.Tools;

import com.paydock.paydocksdk.Services.Config;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.net.URL;


public class ServiceHelper  implements IServiceHelper
{
    static {
        try
        {
            System.setProperty("https.protocols", "TLSv1.2");
        }
        catch (Exception __dummyStaticConstructorCatchVar0)
        {
            throw new ExceptionInInitializerError(__dummyStaticConstructorCatchVar0);
        }
    }

    public String callPaydock(String endpoint, HttpMethod method, String json) throws Exception {
        String url = Config.baseUrl() + endpoint;
        URL obj = new URL(url);
        HttpsURLConnection request = (HttpsURLConnection) obj.openConnection();
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null,null,null);
        request.setSSLSocketFactory(sslContext.getSocketFactory());
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


