package com.paydock.androidsdk;

import com.paydock.javasdk.Models.CustomerPaymentSourceSearchResponse;

public interface IGetPaymentSources {
    void paymentSourcesCallback(CustomerPaymentSourceSearchResponse output);
}
