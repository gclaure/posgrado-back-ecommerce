package com.ecommerce.posgrado.response;

import com.ecommerce.posgrado.entity.RoleEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author gclaure from CochaSoft
 * Date: 5/20/23
 * Time: 23:50
 * Project Name: posgrado
 */
@Setter
@Getter
@Builder
public class UserResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private RoleEntity roleName;

}
