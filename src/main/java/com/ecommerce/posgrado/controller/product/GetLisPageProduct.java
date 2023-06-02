package com.ecommerce.posgrado.controller.product;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.entity.ProductEntity;
import com.ecommerce.posgrado.service.ProductInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @author gclaure from CochaSoft
 * Date: 5/21/23
 * Time: 01:34
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.product.PATH)
@Tag(name = Constants.product.NAME)
public class GetLisPageProduct {

    private final ProductInterfaceService service;

    public GetLisPageProduct(ProductInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Lista de Producto con paginacion")
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @GetMapping("/pageable")
    public Page<ProductEntity> getLisPage(@RequestParam Integer page, @RequestParam Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.service.getProducts(pageable);
    }
}
