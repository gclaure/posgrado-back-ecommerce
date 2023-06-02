package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.request.RegistrationRequest;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 6/1/23
 * Time: 21:55
 * Project Name: posgrado
 */
public interface RegistrationInterfaceService {

    String register(RegistrationRequest request);

    String confirm(String token);
}
