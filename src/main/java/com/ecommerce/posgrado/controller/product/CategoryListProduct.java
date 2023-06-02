package com.ecommerce.posgrado.controller.product;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.entity.ProductEntity;
import com.ecommerce.posgrado.request.ProductRequest;
import com.ecommerce.posgrado.response.PageResponse;
import com.ecommerce.posgrado.service.ProductInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 20:00
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.product.PATH)
@Tag(name = Constants.product.NAME)
public class CategoryListProduct {

    private final ProductInterfaceService service;

    public CategoryListProduct(ProductInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Lista de productos por categoria")
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @GetMapping("/category/{categoryId}/get")
    public PageResponse listProductByCategory(@PathVariable UUID categoryId,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size,
                                              @RequestParam(defaultValue = "id") String sortField,
                                              @RequestParam(defaultValue = "asc") String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        return this.service.listProductByCategory(categoryId, pageable);
    }

}
