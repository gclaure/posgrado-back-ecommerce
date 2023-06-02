package com.ecommerce.posgrado.controller.category;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.entity.CategoryEntity;
import com.ecommerce.posgrado.service.CategoryInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gclaure from CochaSoft
 * Date: 5/21/23
 * Time: 01:12
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.category.PATH)
@Tag(name = Constants.category.NAME)
public class GetAllCategory {

    private final CategoryInterfaceService service;

    public GetAllCategory(CategoryInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Lista de categorias")
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @GetMapping
    public List<CategoryEntity> getAll() {
        return this.service.getAll();
    }

}
