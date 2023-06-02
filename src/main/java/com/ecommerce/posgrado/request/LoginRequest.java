package com.ecommerce.posgrado.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * @author gclaure from CochaSoft
 * Date: 5/31/23
 * Time: 22:00
 * Project Name: posgrado
 */
@Getter
public class LoginRequest {

    @NotBlank(message = "username es requerido!")
    private String username;

    @NotBlank(message = "password es requerido!")
    private String password;

}
