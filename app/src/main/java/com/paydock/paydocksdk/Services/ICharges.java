
package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.*;

public interface ICharges
{
    ChargeResponse add(ChargeRequest request) throws Exception ;

    ChargeItemsResponse get() throws Exception ;

    ChargeItemResponse get(String chargeId) throws Exception ;

    ChargeItemsResponse get(ChargeSearchRequest request) throws Exception ;

}


