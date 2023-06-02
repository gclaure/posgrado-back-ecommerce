package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.ProductEntity;
import com.ecommerce.posgrado.request.ProductRequest;

import java.util.List;
import java.util.UUID;

import com.ecommerce.posgrado.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 21:32 Project Name: posgrado
 */
public interface ProductInterfaceService {

  ProductEntity create(ProductRequest request);

  ProductEntity updateProduct(ProductRequest request, UUID productId);

  ProductEntity getById(UUID id);

  PageResponse listProductByCategory(UUID categoryId, Pageable pageable);

  Page<ProductEntity> getProducts(Pageable pageable);

  PageResponse getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable);

}
