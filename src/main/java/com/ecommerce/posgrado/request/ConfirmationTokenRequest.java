package com.ecommerce.posgrado.request;

import com.ecommerce.posgrado.entity.UserEntity;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 6/1/23
 * Time: 21:19
 * Project Name: posgrado
 */
@Getter
public class ConfirmationTokenRequest {

    private UserEntity user;

    private String token;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

}
