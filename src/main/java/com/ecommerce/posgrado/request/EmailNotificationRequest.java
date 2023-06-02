package com.ecommerce.posgrado.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 6/1/23
 * Time: 21:32
 * Project Name: posgrado
 */
@Builder
@Getter
@Setter
public class EmailNotificationRequest {

    private String to;

    private String subject;

    private String body;

    private boolean hasTemplate;

}
