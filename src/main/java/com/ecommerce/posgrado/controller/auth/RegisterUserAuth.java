package com.ecommerce.posgrado.controller.auth;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.request.RegistrationRequest;
import com.ecommerce.posgrado.service.RegistrationInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 22:26
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.auth.PATH)
@Tag(name = Constants.auth.NAME)
public class RegisterUserAuth {

    private final RegistrationInterfaceService service;

    public RegisterUserAuth(RegistrationInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Registro de nuevo Usuario")
    @PostMapping("/register")
    public String register(@Valid @RequestBody RegistrationRequest request) {
        return this.service.register(request);
    }
}
