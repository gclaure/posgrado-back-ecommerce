package com.ecommerce.posgrado.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/31/23
 * Time: 22:19
 * Project Name: posgrado
 */
@Getter
@Setter
@Configuration
public class JwtConfig {

    @Value("${jwt-config.secret-token}")
    private String secretkeyToken;

    @Value("${jwt-config.secret-refresh-token}")
    private String secretRefreshToken;

    @Value("${jwt-config.expire-toke-minutes}")
    private Integer expireToken;

    @Value("${jwt-config.expire-refresh-token-minutes}")
    private Integer expireRefreshToken;

}
