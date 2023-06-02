package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.ConfirmationTokenEntity;
import com.ecommerce.posgrado.exception.AppHandleException;
import com.ecommerce.posgrado.repository.ConfirmationTokenRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 6/1/23
 * Time: 21:22
 * Project Name: posgrado
 */
@Service
public class ConfirmationTokenImplementService implements ConfirmationTokenInterfaceService {

    private final ConfirmationTokenRepository repository;

    public ConfirmationTokenImplementService(ConfirmationTokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConfirmationTokenEntity create(ConfirmationTokenEntity request) {
        ConfirmationTokenEntity token = new ConfirmationTokenEntity();
        token.setUser(request.getUser());
        token.setToken(request.getToken());
        token.setCreatedAt(request.getCreatedAt());
        token.setExpiresAt(request.getExpiresAt());
        return this.repository.save(token);
    }

    @Override
    public ConfirmationTokenEntity getByToken(String token) {
        return this.repository.findByToken(token)
                .orElseThrow(() -> new AppHandleException("Confirmation token not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public void setConfirmedAt(ConfirmationTokenEntity request) {
        request.setConfirmedAt(LocalDateTime.now());
        this.repository.save(request);
    }
}
