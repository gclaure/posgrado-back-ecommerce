package com.ecommerce.posgrado.request;

import com.ecommerce.posgrado.response.OrderItemResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/21/23
 * Time: 00:46
 * Project Name: posgrado
 */
@Getter
public class OrderRequest {

    private String comment;

    private List<OrderItemResponse> items;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double totalPrice;

}
