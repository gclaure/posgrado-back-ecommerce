package com.ecommerce.posgrado.security.jwt;

import com.ecommerce.posgrado.entity.UserEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author gclaure from CochaSoft
 * Date: 5/29/23
 * Time: 20:25
 * Project Name: posgrado
 */
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtInterfaceService jwtInterfaceService;

    public JwtAuthenticationProvider(JwtInterfaceService jwtInterfaceService) {
        this.jwtInterfaceService = jwtInterfaceService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationToken auth = (JwtAuthenticationToken) authentication;
        String token = (String) auth.getPrincipal();
        UserEntity user = this.jwtInterfaceService.decodeToken(token);
        Object principalToReturn = user;
        return new JwtAuthenticationToken(principalToReturn, user.getAuthorities());


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
