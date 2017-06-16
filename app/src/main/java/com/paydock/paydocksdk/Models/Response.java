package com.paydock.paydocksdk.Models;

public class Response   
{
    private int status;
    public int get_status() {
        return status;
    }
    public void set_status(int value) {
        status = value;
    }

    private String error;
    public String get_error() {
        return error;
    }
    public void set_error(String value) {
        error = value;
    }

    public boolean get_IsSuccess() throws Exception {
        return get_status() == 200 || get_status() == 201;
    }

    private String JsonResponse;
    public String get_JsonResponse() {
        return JsonResponse;
    }
    public void set_JsonResponse(String value) {
        JsonResponse = value;
    }

}


