package com.ecommerce.posgrado.controller.auth;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.response.LoginResponse;
import com.ecommerce.posgrado.service.AuthInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/31/23
 * Time: 23:03
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.auth.PATH)
@Tag(name = Constants.auth.NAME)
public class RefreshTokenAuth {

    private final AuthInterfaceService service;

    public RefreshTokenAuth(AuthInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Refresh token", description = Constants.auth.PUBLIC_ACCESS)
    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestHeader String refreshToken) {
        return this.service.refreshToken(refreshToken);
    }

}
