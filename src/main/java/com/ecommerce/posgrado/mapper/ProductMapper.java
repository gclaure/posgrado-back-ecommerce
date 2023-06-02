package com.ecommerce.posgrado.mapper;

import com.ecommerce.posgrado.entity.ProductEntity;
import com.ecommerce.posgrado.request.ProductRequest;
import com.ecommerce.posgrado.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/21/23
 * Time: 00:14
 * Project Name: posgrado
 */
@Component
public class ProductMapper {

    public ProductEntity fromProductRequest(ProductRequest request) {
        ProductEntity product = new ProductEntity();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setImageUrl(request.getImageUrl());
        product.setActive(request.getActive());
        return product;
    }

    public PageResponse fromEntity(Page<ProductEntity> page) {
        return PageResponse
                .builder()
                .content(page.getContent())
                .last(page.isLast())
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .build();
    }

}
