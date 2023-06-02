package com.ecommerce.posgrado.repository;


import com.ecommerce.posgrado.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gclaure from CochaSoft Date: 5/18/23 Time: 21:40 Project Name: posgrado
 */
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);



}
