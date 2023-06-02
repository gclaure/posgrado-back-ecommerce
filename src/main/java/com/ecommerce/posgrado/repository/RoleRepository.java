package com.ecommerce.posgrado.repository;

import com.ecommerce.posgrado.entity.RoleEntity;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 20:41 Project Name: posgrado
 */
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    Optional<RoleEntity> findByName(String name);

    Boolean existsByName(String name);


}
