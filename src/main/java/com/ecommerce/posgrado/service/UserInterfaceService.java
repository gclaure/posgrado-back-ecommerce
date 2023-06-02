package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.UserEntity;
import com.ecommerce.posgrado.response.UserResponse;

import java.util.UUID;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 21:27 Project Name: posgrado
 */
public interface UserInterfaceService {

    UserResponse getById(UUID id);


    UserEntity create(UserEntity user);

    boolean existEmail(String email);

    UserEntity getByEmail(String email);

    void enableUser(UserEntity user);
}
