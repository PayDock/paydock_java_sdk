
package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.VaultItemResponse;
import com.paydock.javasdk.Models.VaultItemsResponse;
import com.paydock.javasdk.Models.VaultRequest;
import com.paydock.javasdk.Models.VaultResponse;

@SuppressWarnings("unused")
public interface IVault
{
    VaultResponse add(VaultRequest request) throws Exception ;
    VaultItemsResponse get() throws Exception ;
    VaultItemResponse get(String chargeId) throws Exception ;
}


