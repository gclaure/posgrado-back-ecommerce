package com.ecommerce.posgrado.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author gclaure from CochaSoft
 * Date: 6/1/23
 * Time: 21:42
 * Project Name: posgrado
 */
@NoArgsConstructor
@Getter
@Setter
public class OrderItemResponse {

    private UUID productId;

    private Integer quantity;

    @JsonProperty(access = Access.READ_ONLY)
    private BigDecimal totalPrice;

    public OrderItemResponse(UUID productId, Integer quantity, BigDecimal totalPrice) {
        this.quantity = quantity;
        this.productId = productId;
        this.totalPrice = totalPrice;
    }

}
