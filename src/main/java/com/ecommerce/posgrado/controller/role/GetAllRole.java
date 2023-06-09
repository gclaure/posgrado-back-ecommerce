package com.ecommerce.posgrado.controller.role;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.entity.RoleEntity;
import com.ecommerce.posgrado.service.RoleInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/21/23
 * Time: 01:19
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.role.PATH)
@Tag(name = Constants.role.NAME)
public class GetAllRole {

    private final RoleInterfaceService service;

    public GetAllRole(RoleInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Lista de Roles", description = Constants.role.ROLE_ACCESS)
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<RoleEntity> getAll(){
        return this.service.getAll();
    }
}
