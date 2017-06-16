
package com.paydock.paydocksdk.Services;

/**
* Controls startup configuration
*/
public class Config   
{
    private static Environment __Environment = Environment.Sandbox;
    public static Environment getEnvironment() {
        return __Environment;
    }
    public static void setEnvironment(Environment value) {
        __Environment = value;
    }

    private static String __SecretKey = new String();
    public static String getSecretKey() {
        return __SecretKey;
    }
    public static void setSecretKey(String value) {
        __SecretKey = value;
    }

    private static String __PublicKey = new String();
    public static String getPublicKey() {
        return __PublicKey;
    }
    public static void setPublicKey(String value) {
        __PublicKey = value;
    }

    static {
        try
        {
            setEnvironment(getEnvironment().Sandbox);
        }
        catch (Exception __dummyStaticConstructorCatchVar0)
        {
            throw new ExceptionInInitializerError(__dummyStaticConstructorCatchVar0);
        }
    
    }

    /**
    * Initialise configuration for Paydock
    * 
    *  @param env Environment to connect to
    *  @param secretKey Secret key for authentication
    */
    public static void initialise(Environment env, String secretKey, String publicKey) throws Exception {
        setEnvironment(env);
        setSecretKey(secretKey);
        setPublicKey(publicKey);
    }

    /**
    * Base address for the API, based on environment
    * 
    *  @return URL for the environment
    */
    public static String baseUrl() throws Exception {
        return (getEnvironment() == getEnvironment().Sandbox ? "https://api-sandbox.paydock.com/v1/" : "https://api.paydock.com/v1/");
    }

}


