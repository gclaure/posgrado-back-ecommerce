package com.ecommerce.posgrado.repository;

import com.ecommerce.posgrado.entity.CategoryEntity;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gclaure Gustavo Claure Flores Date: 5/20/23 Time: 20:17 Project Name: posgrado
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {

}
