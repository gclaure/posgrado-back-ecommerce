package com.ecommerce.posgrado.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/31/23
 * Time: 22:00
 * Project Name: posgrado
 */
@Setter
@Getter
@Builder
public class LoginResponse {

    private String accessToken;

    private String refreshToken;

    private Long expireTokenIn;

    private Long expireRefreshTokenIn;

    private String tokenType;

}
