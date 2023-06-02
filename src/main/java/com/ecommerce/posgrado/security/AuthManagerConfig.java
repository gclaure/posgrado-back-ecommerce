package com.ecommerce.posgrado.security;

import com.ecommerce.posgrado.security.jwt.JwtAuthenticationProvider;
import com.ecommerce.posgrado.security.jwt.JwtImplementService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/29/23
 * Time: 20:04
 * Project Name: posgrado
 */
@Configuration
public class AuthManagerConfig {

    private final UserDetailService userDetailService;

    private final JwtImplementService jwtImplementService;

    public AuthManagerConfig(UserDetailService userDetailService,
                             JwtImplementService jwtImplementService) {
        this.userDetailService = userDetailService;
        this.jwtImplementService = jwtImplementService;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(daoAuthenticationProvider(), jwtAuthenticationProvider());
    }

    @Bean
    public JwtAuthenticationProvider jwtAuthenticationProvider() {
        return new JwtAuthenticationProvider(this.jwtImplementService);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
