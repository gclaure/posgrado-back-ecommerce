package com.ecommerce.posgrado.controller.role;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.entity.RoleEntity;
import com.ecommerce.posgrado.request.RoleRequest;
import com.ecommerce.posgrado.service.RoleInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 6/1/23
 * Time: 20:36
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.role.PATH)
@Tag(name = Constants.role.NAME)
public class CreateRole {

    private final RoleInterfaceService service;

    public CreateRole(RoleInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Crear nuevo rol", description = Constants.role.ROLE_ACCESS)
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<RoleEntity> createRole(@Valid @RequestBody RoleRequest request) {
        return new ResponseEntity<>(this.service.createRole(request), HttpStatus.CREATED);
    }

}
