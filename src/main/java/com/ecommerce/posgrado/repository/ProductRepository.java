package com.ecommerce.posgrado.repository;

import com.ecommerce.posgrado.entity.CategoryEntity;
import com.ecommerce.posgrado.entity.ProductEntity;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 20:46 Project Name: posgrado
 */
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    Page<ProductEntity> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);

    @Query("select p from ProductEntity p where p.category = ?1")
    Page<ProductEntity> findByCategory(CategoryEntity category, Pageable pageable);

}
