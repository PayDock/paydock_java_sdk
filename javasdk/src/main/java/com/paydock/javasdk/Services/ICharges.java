
package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.ChargeItemResponse;
import com.paydock.javasdk.Models.ChargeItemsResponse;
import com.paydock.javasdk.Models.ChargeRefundResponse;
import com.paydock.javasdk.Models.ChargeRequest;
import com.paydock.javasdk.Models.ChargeRequestStripeConnect;
import com.paydock.javasdk.Models.ChargeResponse;
import com.paydock.javasdk.Models.ChargeSearchRequest;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public interface ICharges
{
    ChargeResponse add(ChargeRequest request) throws Exception;
    ChargeResponse add(ChargeRequestStripeConnect request) throws Exception;
    ChargeResponse authorise(ChargeRequest request) throws Exception;
    ChargeResponse capture(String chargeId) throws Exception;
    ChargeResponse capture(String chargeId, BigDecimal amount) throws Exception;
    ChargeResponse cancelauthorisation(String chargeId) throws Exception;
    ChargeItemsResponse get() throws Exception;
    ChargeItemResponse get(String chargeId) throws Exception;
    ChargeItemsResponse get(ChargeSearchRequest request) throws Exception;
    ChargeRefundResponse refund(String chargeId, BigDecimal amount) throws Exception;
    ChargeRefundResponse archive(String chargeId) throws Exception;
}


