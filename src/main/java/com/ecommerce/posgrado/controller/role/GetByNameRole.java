package com.ecommerce.posgrado.controller.role;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.entity.RoleEntity;
import com.ecommerce.posgrado.service.RoleInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gclaure from CochaSoft
 * Date: 5/21/23
 * Time: 01:16
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.role.PATH)
@Tag(name = Constants.role.NAME)
public class GetByNameRole {

    private final RoleInterfaceService service;

    public GetByNameRole(RoleInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Buscar Role por nombre")
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @GetMapping("/name/{name}")
    public RoleEntity getByName(@PathVariable String name){
        return this.service.getByName(name);
    }
}
