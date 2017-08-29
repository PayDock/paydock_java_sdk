package com.paydock.javasdk.Models;

public class ResponseException  extends Exception
{
    public static final long serialVersionUID = 1L;
    public ErrorResponse errorResponse;
    public ResponseException(ErrorResponse errorResponse, String error) throws Exception {
        super(error);
        this.errorResponse = errorResponse;
    }
}


