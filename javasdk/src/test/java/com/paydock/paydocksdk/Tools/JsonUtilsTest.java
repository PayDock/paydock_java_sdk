package com.paydock.paydocksdk.Tools;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mark on 11/07/2017.
 */
@RunWith(JUnit4.class)
public class JsonUtilsTest {

    String[] stringCase = new String[10];

    @Before
    public void init() throws Exception {
        stringCase[0] = "{\"status\":400,\"error\":{\"message\":\"No gateway type provided\"},\"resource\":{\"type\":\"user\",\"data\":null}}\n"; // Error appears when no gateway type provided while creating
        stringCase[1] = "{\"status\":400,\"error\":{\"message\":{\"message\":\"Invalid Transaction Details\",\"http_status_code\":400,\"errors\":[{\"gateway_specific_code\":\"invalid_credentials\",\"gateway_specific_description\":\"invalid credentialssss\",\"param_name\":null,\"description\":\"Invalid Transaction Details\"}]}},\"resource\":{\"type\":\"gateway\",\"data\":null}}\n"; // Error appears when credentials are not correct
        stringCase[2] = "{\"status\":400,\"error\":{\"message\":\"Credit Card Invalid or Expired\",\"details\":[{\"gateway_specific_code\":\"number\",\"gateway_specific_description\":\"is not a valid card\",\"param_name\":\"number\",\"description\":\"Credit Card Invalid or Expired\"}]}}\n"; // Error appears when credit card is not provided
        stringCase[3] = "{\"status\":400,\"error\":{\"message\":\"Validation Error\",\"details\":[\"No amount provided\"]},\"resource\":{\"type\":\"charge\"}}\n"; // Error appears when some field or fields not valid
        stringCase[4] = "{\"status\":404,\"error\":{\"message\":\"Wrong Api path\"},\"resource\":{\"type\":\"path\",\"data\":null}}\n"; // Error appears when provided resource is not correct
        stringCase[5] = "{\"status\":400,\"error\":{\"message\":\"Invalid Transaction Details\",\"details\":[{\"gateway_specific_code\":\"unknown\",\"gateway_specific_description\":\"unknown error\",\"param_name\":null,\"description\":\"Invalid Transaction Details\"}]}}\n"; // Error appears when some data valid but not exist
        stringCase[6] = "{\"status\":403,\"error\":{\"message\":\"No user with provided secret key\"},\"resource\":{\"type\":\"user\",\"data\":null}}\n"; // Error appears when user does not provide correct credentials
    }

    @Test
    public void test1() throws Exception {
        String message = parseResponse(stringCase[0]);
        Assert.assertTrue(message != null);
    }

    @Test
    public void test2() throws Exception {
        String message = parseResponse(stringCase[1]);
        Assert.assertTrue(message != null);
    }

    @Test
    public void test3() throws Exception {
        String message = parseResponse(stringCase[2]);
        System.out.println(message);
        Assert.assertTrue(message != null);
    }

    @Test
    public void test4() throws Exception {
        String message = parseResponse(stringCase[3]);
        Assert.assertTrue(message != null);
    }

    @Test
    public void test5() throws Exception {
        String message = parseResponse(stringCase[4]);
        Assert.assertTrue(message != null);
    }

    @Test
    public void test6() throws Exception {
        String message = parseResponse(stringCase[5]);
        Assert.assertTrue(message != null);
    }

    @Test
    public void test7() throws Exception {
        String message = parseResponse(stringCase[6]);
        Assert.assertTrue(message != null);
    }

    private String parseResponse(String response) throws Exception {
        String result = null;
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(response);
        JsonObject obj = element.getAsJsonObject(); //since you know it's a JsonObject
        Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();//will return members of your object
        for (Map.Entry<String, JsonElement> entry: entries) {
            //System.out.print("Key Level 1 " + entry.getKey());
            if (entry.getValue().isJsonArray()) {
                //System.out.println("Array.");
            }
            else if(entry.getValue().isJsonObject()) {
                //System.out.println("Object.");
                JsonObject obj1 = entry.getValue().getAsJsonObject(); //since you know it's a JsonObject
                Set<Map.Entry<String, JsonElement>> entries1 = obj1.entrySet();//will return members of your object
                for (Map.Entry<String, JsonElement> entry1: entries1) {
                    //System.out.print("Key Level 2 " + entry1.getKey());
                    if (entry1.getValue().isJsonArray()) {
                        //System.out.println("Array..");
                        JsonArray jsonArray1 = entry1.getValue().getAsJsonArray();
                        Iterator<JsonElement> iterator = jsonArray1.iterator();
//                           while(iterator.hasNext()) {
//                                JsonElement json2 = (JsonElement) iterator.next();
//                                Type founderListType = new TypeToken<ArrayList<iterator>>() {
//                                }.getType();
//                                List<Founder> founderList = gson.fromJson(founderJson, founderListType);
//                            }
                        //obj3.size();
                    }
                    else if(entry1.getValue().isJsonObject()) {
                        //System.out.println("Object..");
                        JsonObject obj2 = entry1.getValue().getAsJsonObject(); //since you know it's a JsonObject
                        Set<Map.Entry<String, JsonElement>> entries2 = obj2.entrySet();//will return members of your object
                        for (Map.Entry<String, JsonElement> entry2: entries2) {
                            //System.out.print("Key Level 3 " + entry2.getKey());
                            if (entry2.getValue().isJsonArray()) {
                                //System.out.println("Array...");
                                JsonArray jsonArray2 = entry2.getValue().getAsJsonArray();
                                //JsonObject obj4 = jsonArray2.getAsJsonObject();
                                //obj4.size();
                            }
                            else if(entry2.getValue().isJsonObject()) {
                                //System.out.println("Object...");
                                JsonObject obj4 = entry2.getValue().getAsJsonObject(); //since you know it's a JsonObject

                            }
                            else if(entry2.getValue().isJsonNull()){
                                //System.out.println("null...");
                            }
                            else if(entry2.getValue().isJsonPrimitive()){
                                //System.out.println(entry2.getValue().getAsString());
                                if (entry2.getKey().equals("message")) {
                                    result = entry2.getValue().getAsString();
                                }
                            }
                        }

                    }
                    else if(entry1.getValue().isJsonNull()){
                        //System.out.println("null..");
                    }
                    else if(entry1.getValue().isJsonPrimitive()){
                        //System.out.println(entry1.getValue().getAsString());
                        if (entry1.getKey().equals("message")) {
                            result = entry1.getValue().getAsString();
                        }
                    }
                }
            }
            else if(entry.getValue().isJsonNull()){
                //System.out.println("null.");
            }
            else if(entry.getValue().isJsonPrimitive()) {
                //System.out.println(entry.getValue().getAsString());
                if (entry.getKey().equals("message")) {
                    result = entry.getValue().getAsString();
                }
            }
        }
        return result;
    }

}
