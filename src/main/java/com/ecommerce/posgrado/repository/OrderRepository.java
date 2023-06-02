package com.ecommerce.posgrado.repository;

import com.ecommerce.posgrado.entity.OrderEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.ecommerce.posgrado.response.OrderItemResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author gclaure Gustavo Claure Flores Date: 5/20/23 Time: 20:49 Project Name: posgrado
 */
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    @Query(value = "SELECT SUM(p.price * oi.quantity) FROM  orders o \n" +
            "JOIN order_item oi ON \n" +
            "oi.oder_id = o.id\n" +
            "JOIN product p ON\n" +
            "oi.product_id = p.id \n" +
            "WHERE o.id = ?1", nativeQuery = true)
    BigDecimal getTotalPrice(String orderId);


    @Query(value = "SELECT new com.ecommerce.posgrado.response.OrderItemResponse(p.id, oi.quantity, (p.price * oi.quantity)) " +
            " FROM OrderEntity o\n" +
            "JOIN o.items oi \n" +
            "JOIN oi.product p \n" +
            "WHERE o.id = ?1")
    List<OrderItemResponse> getItemsWithTotalPrice(UUID orderId);

}
