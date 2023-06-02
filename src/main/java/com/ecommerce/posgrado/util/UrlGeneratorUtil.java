package com.ecommerce.posgrado.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 22:15
 * Project Name: posgrado
 */
public class UrlGeneratorUtil {

    public static String create(String path, String queryName, String queryValue) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(path)
                .queryParam(queryName, queryValue)
                .build()
                .toUriString();
    }

}
