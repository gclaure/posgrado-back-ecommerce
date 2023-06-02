package com.ecommerce.posgrado.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author gclaure from CochaSoft
 * Date: 5/21/23
 * Time: 00:20
 * Project Name: posgrado
 */
@Setter
@Getter
@Builder
public class PageResponse {

    private Object content;

    private boolean last;

    private int pageNumber;

    private int pageSize;

    private int totalPages;

    private long totalElements;

}
