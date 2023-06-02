package com.ecommerce.posgrado.request;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 22:35 Project Name: posgrado
 */
@Getter
public class ProductRequest {

    private String name;

    private String description;

    private String imageUrl;

    private BigDecimal price;

    private Integer stock;

    private Boolean active;

    private UUID categoryId;

}
