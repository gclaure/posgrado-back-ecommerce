package com.ecommerce.posgrado.request;

import lombok.Getter;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 21:55
 * Project Name: posgrado
 */
@Getter
public class RegistrationRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String address;

}
