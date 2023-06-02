package com.ecommerce.posgrado.repository;

import com.ecommerce.posgrado.entity.ConfirmationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 6/1/23
 * Time: 21:14
 * Project Name: posgrado
 */
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenEntity, UUID> {

    Optional<ConfirmationTokenEntity> findByToken(String token);
}
