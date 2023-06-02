package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.UserEntity;
import com.ecommerce.posgrado.exception.AppHandleException;
import com.ecommerce.posgrado.request.LoginRequest;
import com.ecommerce.posgrado.response.LoginResponse;
import com.ecommerce.posgrado.response.UserResponse;
import com.ecommerce.posgrado.security.jwt.JwtInterfaceService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author gclaure from CochaSoft
 * Date: 5/31/23
 * Time: 22:01
 * Project Name: posgrado
 */
@Service
public class AuthImplementService implements AuthInterfaceService {

    private final AuthenticationManager authenticationManager;

    private final JwtInterfaceService jwtInterfaceService;


    public AuthImplementService(AuthenticationManager authenticationManager,
                                JwtInterfaceService jwtInterfaceService) {
        this.authenticationManager = authenticationManager;
        this.jwtInterfaceService = jwtInterfaceService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication auth = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword());
        Authentication authResult = this.authenticationManager.authenticate(auth);
        UserEntity user = (UserEntity) authResult.getPrincipal();
        return this.jwtInterfaceService.createToken(user);

    }

    @Override
    public LoginResponse refreshToken(String refreshToken) {
        if (refreshToken == null)
            throw new AppHandleException("Token es requerido!", HttpStatus.UNPROCESSABLE_ENTITY);

        UserEntity user = this.jwtInterfaceService.decodeRefreshToken(refreshToken);
        return this.jwtInterfaceService.createToken(user);
    }

    @Override
    public UserResponse me(String token) {
        UserEntity user = this.jwtInterfaceService.decodeToken(token);
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

}
