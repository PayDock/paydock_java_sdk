
package com.paydock.paydocksdk.Tools;

import java.net.URLEncoder;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class UrlExtensionMethods
{
    public static String appendParameter(String url, String parameterName, String value) throws Exception {
        if (value != null)
            return addUrlParameter(url,parameterName,value);
         
        return url;
    }

    public static String appendParameter(String url, String parameterName, Integer value) throws Exception {
        if (value != null)
            return addUrlParameter(url, parameterName, value.toString());
         
        return url;
    }

    public static String appendParameter(String url, String parameterName, Date value) throws Exception {
        if (value != null) {
            String df = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.getDefault())).format(value);
            return addUrlParameter(url, parameterName, df);
        }
        return url;
    }

    public static String appendParameter(String url, String parameterName, Boolean value) throws Exception {
        if (value != null)
            return addUrlParameter(url, parameterName, value.toString().toLowerCase());
         
        return url;
    }

    private static String addUrlParameter(String currrentUrl, String name, String value) throws Exception {
        if (!currrentUrl.contains("?"))
            currrentUrl += "?";
        else
            currrentUrl += "&"; 
        return currrentUrl + URLEncoder.encode(name, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8");
    }

}


