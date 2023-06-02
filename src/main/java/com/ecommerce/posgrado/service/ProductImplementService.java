package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.CategoryEntity;
import com.ecommerce.posgrado.entity.ProductEntity;
import com.ecommerce.posgrado.exception.AppHandleException;
import com.ecommerce.posgrado.mapper.ProductMapper;
import com.ecommerce.posgrado.repository.ProductRepository;
import com.ecommerce.posgrado.request.ProductRequest;

import java.math.RoundingMode;
import java.util.UUID;

import com.ecommerce.posgrado.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 21:32 Project Name: posgrado
 */
@Service
public class ProductImplementService implements ProductInterfaceService {

    private final ProductRepository productRepository;

    private final CategoryInterfaceService categoryInterfaceService;

    private final ProductMapper productMapper;

    public ProductImplementService(ProductRepository productRepository,
                                   CategoryInterfaceService categoryInterfaceService,
                                   ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryInterfaceService = categoryInterfaceService;
        this.productMapper = productMapper;
    }

    @Override
    public ProductEntity create(ProductRequest request) {
        CategoryEntity category = this.categoryInterfaceService.getById(request.getCategoryId());
        ProductEntity product = this.productMapper.fromProductRequest(request);
        product.setCategory(category);
        return this.productRepository.save(product);
    }

    @Override
    public ProductEntity updateProduct(ProductRequest request, UUID productId) {
        ProductEntity product = this.productRepository.findById(productId)
                .orElseThrow(() -> new AppHandleException("category not found!", HttpStatus.NOT_FOUND));
        CategoryEntity category = this.categoryInterfaceService.getById(request.getCategoryId());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setImageUrl(request.getImageUrl());
        product.setPrice(request.getPrice().setScale(2, RoundingMode.HALF_UP));
        product.setStock(request.getStock());
        product.setActive(request.getActive());
        product.setCategory(category);
        return this.productRepository.save(product);
    }

    @Override
    public ProductEntity getById(UUID id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new AppHandleException("product not found!", HttpStatus.NOT_FOUND));
    }

    @Override
    public PageResponse listProductByCategory(UUID categoryId, Pageable pageable) {
        CategoryEntity category = this.categoryInterfaceService.getById(categoryId);
        Page<ProductEntity> page = this.productRepository.findByCategory(category, pageable);
        return this.productMapper.fromEntity(page);
    }

    @Override
    public Page<ProductEntity> getProducts(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    @Override
    public PageResponse getFilteredProducts(Double minPrice,
                                            Double maxPrice,
                                            Pageable pageable) {
        if (minPrice == null) {
            minPrice = Double.MIN_VALUE;
        }

        if (maxPrice == null) {
            maxPrice = Double.MAX_VALUE;
        }
        Page<ProductEntity> page = this.productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
        return this.productMapper.fromEntity(page);
    }

}
