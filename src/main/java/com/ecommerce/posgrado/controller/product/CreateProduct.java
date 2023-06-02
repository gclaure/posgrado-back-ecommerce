package com.ecommerce.posgrado.controller.product;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.entity.ProductEntity;
import com.ecommerce.posgrado.request.ProductRequest;
import com.ecommerce.posgrado.service.ProductInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/21/23
 * Time: 01:28
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.product.PATH)
@Tag(name = Constants.product.NAME)
public class CreateProduct {

    private final ProductInterfaceService service;

    public CreateProduct(ProductInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Crear nuevo producto", description = Constants.product.ROLE_ACCESS)
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ProductEntity create(@Valid @RequestBody ProductRequest request) {
        return this.service.create(request);
    }
}
