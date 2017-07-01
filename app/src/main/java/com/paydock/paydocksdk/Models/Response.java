package com.paydock.paydocksdk.Models;

public class Response   
{
    private Integer status;
    public int get_status() {return status;}
    public void set_status(Integer value) {status = value;}

    private ErrorResponse error;
    public ErrorResponse get_error() {return error;}
    public void set_error(ErrorResponse value) {error = value;}

    public Boolean get_IsSuccess() throws Exception {
        return get_status() == 200 || get_status() == 201;
    }

    private String jsonResponse;
    public String get_jsonResponse() {
        return jsonResponse;
    }
    public void set_jsonResponse(String value) {
        jsonResponse = value;
    }

}


