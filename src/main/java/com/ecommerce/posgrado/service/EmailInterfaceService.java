package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.request.EmailNotificationRequest;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 6/1/23
 * Time: 21:30
 * Project Name: posgrado
 */
public interface EmailInterfaceService {

    String send(EmailNotificationRequest request);
}
