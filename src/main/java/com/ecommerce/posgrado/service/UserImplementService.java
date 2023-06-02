package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.UserEntity;
import com.ecommerce.posgrado.exception.AppHandleException;
import com.ecommerce.posgrado.repository.UserRepository;
import com.ecommerce.posgrado.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 21:27 Project Name: posgrado
 */
@Service
public class UserImplementService implements UserInterfaceService {

    private final UserRepository userRepository;

    public UserImplementService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse getById(UUID id) {
        UserEntity user = this.userRepository.findById(id)
                .orElseThrow(() -> new AppHandleException("User not foud!", HttpStatus.NOT_FOUND));
        return UserResponse
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .address(user.getAddress())
                .roleName(user.getRole())
                .build();
    }

    @Override
    public UserEntity create(UserEntity user) {
        return this.userRepository.save(user);
    }

    @Override
    public boolean existEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public UserEntity getByEmail(String email) {
        return this.userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new AppHandleException(String
                                .format("User with email %s not found", email),
                                HttpStatus.BAD_REQUEST));
    }

    @Override
    public void enableUser(UserEntity user) {
        user.setEnable(Boolean.TRUE);
        this.userRepository.save(user);
    }
}
