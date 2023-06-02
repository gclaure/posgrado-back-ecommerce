package com.ecommerce.posgrado.controller.product;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.entity.ProductEntity;
import com.ecommerce.posgrado.request.ProductRequest;
import com.ecommerce.posgrado.service.ProductInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 19:35
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.product.PATH)
@Tag(name = Constants.product.NAME)
public class UpdateProduct {

    private final ProductInterfaceService service;

    public UpdateProduct(ProductInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Actualizar producto por id")
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @PutMapping("/{productId}")
    public ProductEntity updateProduct(@Valid @RequestBody ProductRequest request,
                                       @PathVariable UUID productId) {
        return this.service.updateProduct(request, productId);
    }
}
