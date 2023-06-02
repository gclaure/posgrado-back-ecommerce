package com.ecommerce.posgrado.controller.order;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.request.OrderRequest;
import com.ecommerce.posgrado.service.OrderInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/21/23
 * Time: 01:22
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.order.PATH)
@Tag(name = Constants.order.NAME)
public class CreateOrder {

    private final OrderInterfaceService service;

    public CreateOrder(OrderInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Crear nueva Orden", description = Constants.order.ROLE_ACCESS)
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public String createNewOrder(@Valid @RequestBody OrderRequest request){
        return this.service.createNewOrder(request);
    }

}
