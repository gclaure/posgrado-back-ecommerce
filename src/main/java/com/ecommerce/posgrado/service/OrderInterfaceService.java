package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.request.OrderRequest;
import com.ecommerce.posgrado.response.OrderResponse;

import java.util.UUID;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/21/23
 * Time: 00:43
 * Project Name: posgrado
 */
public interface OrderInterfaceService {

    String createNewOrder(OrderRequest request);

    OrderResponse getById(UUID id);

}
