package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.VaultItemResponse;
import com.paydock.javasdk.Models.VaultItemsResponse;
import com.paydock.javasdk.Models.VaultRequest;
import com.paydock.javasdk.Models.VaultResponse;
import com.paydock.javasdk.PayDock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@SuppressWarnings("SameParameterValue")
@RunWith(JUnit4.class)
public class VaultTest {

    @Before
    public void init() throws Exception {
        Config.initialise(Environment.Sandbox, PayDock.SecretKey, PayDock.PublicKey);
    }

    private VaultResponse CreateVaultToken() throws Exception {
        VaultRequest request = new VaultRequest();
            request.card_name = "Test Name";
            request.card_number = "5520000000000000";
            request.expire_month = "10";
            request.expire_year = "2020";
        return new Vault().add(request);
    }

    @Test
    public void add() throws Exception {
        VaultResponse vaultResponse = CreateVaultToken();
        Assert.assertTrue(vaultResponse.get_IsSuccess());
    }


    @Test
    public void get() throws Exception {
        VaultItemsResponse result = new Vault().get();
        Assert.assertTrue(result.get_IsSuccess());
    }

    @Test
    public void get1() throws Exception {
        VaultResponse vaultResponse = CreateVaultToken();
        VaultItemResponse result = new Vault().get(vaultResponse.resource.data.vault_token);
        Assert.assertTrue(result.get_IsSuccess());
    }

}