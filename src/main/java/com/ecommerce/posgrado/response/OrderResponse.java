package com.ecommerce.posgrado.response;

import com.ecommerce.posgrado.entity.OrderStateEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 21:41
 * Project Name: posgrado
 */
@Getter
@Setter
@Builder
public class OrderResponse {

    private String comment;

    private List<OrderItemResponse> items;

    @JsonProperty(access = Access.READ_ONLY)
    private BigDecimal totalPrice;

    @JsonProperty(access = Access.READ_ONLY)
    private OrderStateEnum state;

}
