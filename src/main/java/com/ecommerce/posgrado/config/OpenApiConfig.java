package com.ecommerce.posgrado.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Configuration;

/**
 * @author gclaure from CochaSoft
 * Date: 5/20/23
 * Time: 23:12
 * Project Name: posgrado
 */
@Configuration
@SecurityScheme(
        name = "Bearer-Token",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        description = "Authentication JWT"
)
public class OpenApiConfig implements OpenApiCustomiser {

    private final SwaggerConfig swaggerConfig;

    public OpenApiConfig(SwaggerConfig swaggerConfig) {
        this.swaggerConfig = swaggerConfig;
    }

    @Override
    public void customise(OpenAPI openApi) {
        final var info = new Info().title(this.swaggerConfig.getTitle())
                .version(this.swaggerConfig.getVersion())
                .description(this.swaggerConfig.getDescription())
                .contact(new Contact()
                        .email(this.swaggerConfig.getEmail())
                        .name(this.swaggerConfig.getBusinessName())
                        .url(this.swaggerConfig.getUrl()))
                .termsOfService(this.swaggerConfig.getTermOfService())
                .license(new License()
                        .name(this.swaggerConfig.getLicenseName())
                        .url(this.swaggerConfig.getLicenseUrl()));
        openApi.info(info);
    }
}
