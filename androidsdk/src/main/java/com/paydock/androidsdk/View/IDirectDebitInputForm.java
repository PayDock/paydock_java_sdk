package com.paydock.androidsdk.View;

import com.paydock.androidsdk.IGetToken;
import com.paydock.javasdk.Services.Environment;

public interface IDirectDebitInputForm {

    void getToken(Environment environment, String publicKey, String gatewayID, IGetToken delegateInterface);
    Boolean validate();
    void clear();
}
