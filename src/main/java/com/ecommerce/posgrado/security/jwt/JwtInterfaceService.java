package com.ecommerce.posgrado.security.jwt;

import com.ecommerce.posgrado.entity.UserEntity;
import com.ecommerce.posgrado.response.LoginResponse;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/29/23
 * Time: 20:30
 * Project Name: posgrado
 */
public interface JwtInterfaceService {

    LoginResponse createToken(UserEntity user);

    UserEntity decodeToken(String token);

    UserEntity decodeRefreshToken(String token);
}
