package com.ecommerce.posgrado.response;


/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 23:42
 * Project Name: posgrado
 */
public interface OrderItemInterfaceResponse {


     String getProductId();

     Integer getQuantity();

     Double getTotalPrice();

}
