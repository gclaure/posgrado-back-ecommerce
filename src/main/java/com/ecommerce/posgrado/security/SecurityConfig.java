package com.ecommerce.posgrado.security;

import com.ecommerce.posgrado.security.jwt.JwtAuthenticationFilter;
import com.ecommerce.posgrado.security.jwt.JwtEntryPointSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/29/23
 * Time: 20:10
 * Project Name: posgrado
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final JwtEntryPointSecurity jwtEntryPointSecurity;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
                          JwtEntryPointSecurity jwtEntryPointSecurity) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtEntryPointSecurity = jwtEntryPointSecurity;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .antMatchers(
                        "/api/v1/auth/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                )
                .permitAll()
                .antMatchers("/api/v1/product/**",
                        "/api/v1/category",
                        "/api/v1/category/**",
                        "/api/v1/order/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(this.jwtEntryPointSecurity)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


}
