package com.paydock.paydocksdk.Models;

public class Response   
{
    public Integer status;
    public ErrorResponse error;
    public String jsonResponse;

    public Boolean get_IsSuccess() throws Exception {
        return status == 200 || status == 201;
    }

}


