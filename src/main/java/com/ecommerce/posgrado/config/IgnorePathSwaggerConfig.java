package com.ecommerce.posgrado.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gclaure from CochaSoft
 * Date: 6/2/23
 * Time: 11:18
 * Project Name: posgrado
 */
@Component
@Getter
@Setter
@ConfigurationProperties("ignored-swagger")
public class IgnorePathSwaggerConfig {

    String[] paths;

}
