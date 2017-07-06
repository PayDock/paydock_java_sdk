
package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.*;

import java.math.BigDecimal;


public interface ICharges
{
    ChargeResponse add(ChargeRequest request) throws Exception ;
    ChargeItemsResponse get() throws Exception ;
    ChargeItemResponse get(String chargeId) throws Exception ;
    ChargeItemsResponse get(ChargeSearchRequest request) throws Exception ;
    ChargeRefundResponse refund(String chargeId, BigDecimal amount) throws Exception;
    ChargeRefundResponse archive(String chargeId) throws Exception;
}


