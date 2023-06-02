package com.ecommerce.posgrado.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 6/1/23
 * Time: 20:27
 * Project Name: posgrado
 */
@Getter
public class RoleRequest {

    @NotBlank(message = "name is required!")
    private String name;

    private String description;

}
