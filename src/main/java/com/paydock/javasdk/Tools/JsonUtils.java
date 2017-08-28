package com.paydock.javasdk.Tools;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


@SuppressWarnings({"StatementWithEmptyBody", "UnusedAssignment"})
public class JsonUtils {

    public static String parseResponse(String response) {
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
