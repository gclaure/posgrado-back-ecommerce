package com.ecommerce.posgrado.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gclaure from CochaSoft
 * Date: 6/2/23
 * Time: 11:24
 * Project Name: posgrado
 */
@Component
@Getter
@Setter
@ConfigurationProperties("ignored-security")
public class IgnorePathSecurityConfig {

    String[] paths;

}
