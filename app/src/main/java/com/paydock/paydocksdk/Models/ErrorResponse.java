
package com.paydock.paydocksdk.Models;


public class ErrorResponse
{
    private int Status;
    public int get_Status() {
        return Status;
    }
    public void set_Status(int value) {
        Status = value;
    }

    private String ErrorMessage;
    public String get_ErrorMessage() {
        return ErrorMessage;
    }
    public void set_ErrorMessage(String value) {
        ErrorMessage = value;
    }

//    private dynamic ExtendedInformation = new dynamic();
//    public dynamic get_ExtendedInformation() {
//        return ExtendedInformation;
//    }
//
//    public void set_ExtendedInformation(dynamic value) {
//        ExtendedInformation = value;
//    }

    private String JsonResponse;
    public String get_JsonResponse() {
        return JsonResponse;
    }
    public void set_JsonResponse(String value) {
        JsonResponse = value;
    }

}


