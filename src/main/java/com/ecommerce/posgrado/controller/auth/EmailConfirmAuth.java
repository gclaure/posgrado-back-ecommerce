package com.ecommerce.posgrado.controller.auth;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.service.RegistrationInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 22:21
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.auth.PATH)
@Tag(name = Constants.auth.NAME)
public class EmailConfirmAuth {

    private final RegistrationInterfaceService service;

    public EmailConfirmAuth(RegistrationInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Confirmar correo electronico")
    @GetMapping("/confirm")
    public String confirm(@RequestParam String token) {
        return this.service.confirm(token);
    }

}
