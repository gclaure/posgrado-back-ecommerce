package com.ecommerce.posgrado.security;

import com.ecommerce.posgrado.config.IgnorePathSecurityConfig;
import com.ecommerce.posgrado.config.IgnorePathSwaggerConfig;
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

    private final IgnorePathSwaggerConfig ignorePathSwaggerConfig;

    private final IgnorePathSecurityConfig ignorePathSecurityConfig;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
                          JwtEntryPointSecurity jwtEntryPointSecurity,
                          IgnorePathSwaggerConfig ignorePathSwaggerConfig,
                          IgnorePathSecurityConfig ignorePathSecurityConfig) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtEntryPointSecurity = jwtEntryPointSecurity;
        this.ignorePathSwaggerConfig = ignorePathSwaggerConfig;
        this.ignorePathSecurityConfig = ignorePathSecurityConfig;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .antMatchers(this.ignorePathSwaggerConfig.getPaths()).permitAll()
                .antMatchers(this.ignorePathSecurityConfig.getPaths()).permitAll()
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
