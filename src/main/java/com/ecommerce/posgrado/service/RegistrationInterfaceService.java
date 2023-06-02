package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.request.RegistrationRequest;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 21:55
 * Project Name: posgrado
 */
public interface RegistrationInterfaceService {

    String register(RegistrationRequest request);

    String confirm(String token);
}
