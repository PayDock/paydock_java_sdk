package com.paydock.androidsdk.View;


import com.paydock.javasdk.Services.Environment;

public interface IVaultedPaymentSourcesInputForm {
    void getVaultedPaymentSources(Environment environment, String publicKey, String queryToken);
}
