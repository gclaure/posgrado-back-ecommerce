package com.ecommerce.posgrado.controller.product;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.entity.ProductEntity;
import com.ecommerce.posgrado.service.ProductInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author gclaure from CochaSoft
 * Date: 5/21/23
 * Time: 01:31
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.product.PATH)
@Tag(name = Constants.product.NAME)
public class GetByIdProduct {

    private final ProductInterfaceService service;

    public GetByIdProduct(ProductInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Buscar producto por id")
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @GetMapping("/{id}")
    public ProductEntity getByid(@PathVariable UUID id) {
        return this.service.getById(id);
    }

}
