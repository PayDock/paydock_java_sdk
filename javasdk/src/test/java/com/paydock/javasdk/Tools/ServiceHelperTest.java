package com.paydock.javasdk.Tools;

import com.paydock.javasdk.Services.Config;
import com.paydock.javasdk.Services.Environment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

@RunWith(JUnit4.class)
public class ServiceHelperTest {

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, "", "");
    }

    @Test
    public void testTimeoutPasses() throws Exception {
        String message = callPaydock("charges", HttpMethod.GET,"",false, 30000);
        Assert.assertTrue(!message.equals("connect timed out"));
    }

    @Test
    public void testTimeoutFails() throws Exception {
        String message = callPaydock("charges", HttpMethod.GET,"",false, 1);
        Assert.assertTrue(message.equals("connect timed out"));
    }


    private String callPaydock(String endpoint, HttpMethod method, String json, boolean excludeSecretKey,
                               int HTTP_REQUEST_TIMEOUT) throws Exception {

        String result = null;
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
        if (!excludeSecretKey) {
            request.setRequestProperty("x-user-secret-key", Config.getSecretKey());
        } else {
            request.setRequestProperty("x-user-public-key", Config.getPublicKey());
        }
        request.setUseCaches (false);

        try
        {
            request.connect();
            int httpCode = request.getResponseCode();
            BufferedReader rd;

            if (httpCode == 200 || httpCode == 201)
            {
                rd = new BufferedReader(new InputStreamReader(request.getInputStream()));
            }
            else
            {
                rd = new BufferedReader(new InputStreamReader(request.getErrorStream()));
            }

            String line;
            StringBuilder response = new StringBuilder();

            while((line = rd.readLine()) != null) {
                response.append(line).append('\n');
            }
            rd.close();
            result = response.toString();

        } catch (SocketTimeoutException e){
            return (e.getMessage());
        }
        finally
        {
            request.disconnect();
        }
        return result;
    }

}
