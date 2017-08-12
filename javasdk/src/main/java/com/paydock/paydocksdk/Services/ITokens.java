package com.paydock.paydocksdk.Services;

import com.paydock.paydocksdk.Models.TokenRequest;
import com.paydock.paydocksdk.Models.TokenResponse;

public interface ITokens {

    TokenResponse create(TokenRequest request) throws Exception;
}
