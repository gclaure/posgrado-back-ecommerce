package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.CategoryEntity;
import com.ecommerce.posgrado.exception.AppHandleException;
import com.ecommerce.posgrado.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author gclaure Gustavo Claure Flores Date: 5/20/23 Time: 19:55 Project Name: posgrado
 */
@Service
public class CategoryImplementService implements CategoryInterfaceService {

    private final CategoryRepository categoryRepository;

    public CategoryImplementService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity getById(UUID id) {
        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new AppHandleException("category not found!", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<CategoryEntity> getAll() {
        return (List<CategoryEntity>) this.categoryRepository.findAll();
    }
}
