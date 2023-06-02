package com.ecommerce.posgrado.controller.order;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.response.OrderResponse;
import com.ecommerce.posgrado.service.OrderInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 23:08
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.order.PATH)
@Tag(name = Constants.order.NAME)
public class GetOrder {

    private final OrderInterfaceService service;

    public GetOrder(OrderInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Ver Orden por id")
    @SecurityRequirement(name = Constants.security.AUTHORIZATION)
    @GetMapping("/{orderId}")
    public OrderResponse getOrderByid(@PathVariable UUID orderId){
        return this.service.getById(orderId);
    }
}
