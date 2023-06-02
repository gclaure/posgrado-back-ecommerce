package com.ecommerce.posgrado.controller.product;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.response.PageResponse;
import com.ecommerce.posgrado.service.ProductInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;

/**
 * @author gclaure from CochaSoft
 * Date: 5/21/23
 * Time: 01:37
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.product.PATH)
@Tag(name = Constants.product.NAME)
public class GetFilterPageProduct {

    private final ProductInterfaceService service;

    public GetFilterPageProduct(ProductInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Lista de productos con filtros y paginacion")
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @GetMapping
    public PageResponse getLisPage(@RequestParam(required = false) Double minPrice,
                                   @RequestParam(required = false) Double maxPrice,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "20") int size,
                                   @RequestParam(defaultValue = "id") String sortField,
                                   @RequestParam(defaultValue = "asc") String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        return this.service.getFilteredProducts(minPrice, maxPrice, pageable);
    }
}
