package com.ecommerce.posgrado.controller.user;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.response.UserResponse;
import com.ecommerce.posgrado.service.UserInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author gclaure Gustavo Claure Flores Date: 5/20/23 Time: 20:19 Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.user.PATH)
@Tag(name = Constants.user.NAME)
public class GetByIdUser {

    private final UserInterfaceService service;

    public GetByIdUser(UserInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Buscar usuario por id", description = Constants.user.ROLE_ACCESS)
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("{id}")
    public UserResponse getById(@PathVariable UUID id) {
        return this.service.getById(id);
    }
}
