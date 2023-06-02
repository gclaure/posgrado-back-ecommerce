package com.ecommerce.posgrado.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/20/23
 * Time: 23:13
 * Project Name: posgrado
 */
@Getter
@Setter
@Configuration
public class SwaggerConfig {

    @Value("${app-swagger.title}")
    private String title;

    @Value("${app-swagger.description}")
    private String description;

    @Value("${app-swagger.version}")
    private String version;

    @Value("${app-swagger.email}")
    private String email;

    @Value("${app-swagger.name-business}")
    private String businessName;

    @Value("${app-swagger.url}")
    private String url;

    @Value("${app-swagger.terms-of-service}")
    private String termOfService;

    @Value("${app-swagger.license-name}")
    private String licenseName;

    @Value("${app-swagger.license-url}")
    private String licenseUrl;

}
