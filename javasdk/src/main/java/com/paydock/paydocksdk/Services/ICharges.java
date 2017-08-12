
package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.ChargeItemResponse;
import com.paydock.paydocksdk.Models.ChargeItemsResponse;
import com.paydock.paydocksdk.Models.ChargeRefundResponse;
import com.paydock.paydocksdk.Models.ChargeRequest;
import com.paydock.paydocksdk.Models.ChargeResponse;
import com.paydock.paydocksdk.Models.ChargeSearchRequest;
import java.math.BigDecimal;

@SuppressWarnings("unused")
public interface ICharges
{
    ChargeResponse add(ChargeRequest request) throws Exception ;
    ChargeItemsResponse get() throws Exception ;
    ChargeItemResponse get(String chargeId) throws Exception ;
    ChargeItemsResponse get(ChargeSearchRequest request) throws Exception ;
    ChargeRefundResponse refund(String chargeId, BigDecimal amount) throws Exception;
    ChargeRefundResponse archive(String chargeId) throws Exception;
}


