
package com.paydock.javasdk.Services;


@SuppressWarnings("SameParameterValue")
public class Config
{
    private static Environment __Environment = Environment.Sandbox;
    private static Environment getEnvironment() {
        return __Environment;
    }
    private static void setEnvironment(Environment value) {
        __Environment = value;
    }

    private static String __SecretKey;
    public static String getSecretKey() {
        return __SecretKey;
    }
    private static void setSecretKey(String value) {
        __SecretKey = value;
    }

    private static String __PublicKey;
    public static String getPublicKey() {
        return __PublicKey;
    }
    private static void setPublicKey(String value) {
        __PublicKey = value;
    }


    public static void initialise(Environment env, String secretKey, String publicKey) throws Exception {
        setEnvironment(env);
        setSecretKey(secretKey);
        setPublicKey(publicKey);
    }

    public static String baseUrl() throws Exception {
        return (getEnvironment() == Environment.Sandbox ? "https://api-sandbox.paydock.com/v1/" : "https://api.paydock.com/v1/");
    }

}


