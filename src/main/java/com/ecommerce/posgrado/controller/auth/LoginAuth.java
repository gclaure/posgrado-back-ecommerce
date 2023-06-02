package com.ecommerce.posgrado.controller.auth;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.request.LoginRequest;
import com.ecommerce.posgrado.response.LoginResponse;
import com.ecommerce.posgrado.service.AuthInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author gclaure from CochaSoft
 * Date: 5/31/23
 * Time: 21:28
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.auth.PATH)
@Tag(name = Constants.auth.NAME)
public class LoginAuth {

    private final AuthInterfaceService service;

    public LoginAuth(AuthInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Login")
    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return this.service.login(request);
    }

}
