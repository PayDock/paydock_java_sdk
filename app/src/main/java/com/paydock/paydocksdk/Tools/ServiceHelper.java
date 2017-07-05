
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
    private static final int HTTP_REQUEST_TIMEOUT = 10000;

    public String callPaydock(String endpoint, HttpMethod method, String json, boolean excludeSecretKey) throws Exception {
        String url = Config.baseUrl() + endpoint;
        URL obj = new URL(url);
        HttpsURLConnection request = (HttpsURLConnection) obj.openConnection();
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null,null,null);
        request.setSSLSocketFactory(sslContext.getSocketFactory());
        request.setConnectTimeout(HTTP_REQUEST_TIMEOUT);
        request.setReadTimeout(HTTP_REQUEST_TIMEOUT);
        String methodString  = method.toString();
        request.setRequestMethod(methodString);
        request.setRequestProperty("content-type","application/json");
        if (!excludeSecretKey)
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
        finally
        {
            request.disconnect();
        }
    }
}


