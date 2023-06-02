package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.request.LoginRequest;
import com.ecommerce.posgrado.response.LoginResponse;
import com.ecommerce.posgrado.response.UserResponse;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/31/23
 * Time: 21:59
 * Project Name: posgrado
 */
public interface AuthInterfaceService {

    LoginResponse login(LoginRequest request);

    LoginResponse refreshToken(String refreshToken);

    UserResponse me(String token);

}
