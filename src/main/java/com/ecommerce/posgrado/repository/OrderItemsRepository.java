package com.ecommerce.posgrado.repository;

import com.ecommerce.posgrado.entity.OrderItemsEntity;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 20:51 Project Name: posgrado
 */
public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, UUID> {

}
