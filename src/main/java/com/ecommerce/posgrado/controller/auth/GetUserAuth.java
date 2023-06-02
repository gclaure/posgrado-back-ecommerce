package com.ecommerce.posgrado.controller.auth;

import com.ecommerce.posgrado.controller.Constants;
import com.ecommerce.posgrado.response.UserResponse;
import com.ecommerce.posgrado.service.AuthInterfaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * @author gclaure from CochaSoft
 * Date: 5/31/23
 * Time: 23:16
 * Project Name: posgrado
 */
@RestController
@RequestMapping(Constants.auth.PATH)
@Tag(name = Constants.auth.NAME)
public class GetUserAuth {

    private final AuthInterfaceService service;

    public GetUserAuth(AuthInterfaceService service) {
        this.service = service;
    }

    @Operation(summary = "Get User data")
    @PostMapping("/getUser")
    public UserResponse getUser(@RequestHeader String token) {
        return this.service.me(token);
    }

}
