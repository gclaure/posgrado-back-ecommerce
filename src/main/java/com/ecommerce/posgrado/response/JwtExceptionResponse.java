package com.ecommerce.posgrado.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 00:01
 * Project Name: posgrado
 */
@Getter
@Setter
@Builder
public class JwtExceptionResponse {

    private Boolean status;

    private String message;

    private LocalDateTime time;
}
