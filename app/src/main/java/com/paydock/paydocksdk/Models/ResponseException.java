package com.paydock.paydocksdk.Models;

import com.paydock.paydocksdk.Models.ErrorResponse;

public class ResponseException  extends Exception 
{
    private ErrorResponse errorResponse;
    public ErrorResponse get_ErrorResponse() {
        return errorResponse;
    }
    public void set_ErrorResponse(ErrorResponse value) {
        errorResponse = value;
    }

    public ResponseException(ErrorResponse errorResponse, String error) throws Exception {
        super(error);
        this.set_ErrorResponse(errorResponse);
    }

}


