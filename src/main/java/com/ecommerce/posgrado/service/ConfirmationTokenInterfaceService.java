package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.ConfirmationTokenEntity;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 6/1/23
 * Time: 21:17
 * Project Name: posgrado
 */
public interface ConfirmationTokenInterfaceService {

    ConfirmationTokenEntity create(ConfirmationTokenEntity request);

    ConfirmationTokenEntity getByToken(String token);

    void setConfirmedAt(ConfirmationTokenEntity request);

}
