package com.paydock.javasdk.Services;

import com.paydock.javasdk.Models.TokenRequest;
import com.paydock.javasdk.Models.TokenResponse;

public interface ITokens {

    TokenResponse create(TokenRequest request) throws Exception;
}
