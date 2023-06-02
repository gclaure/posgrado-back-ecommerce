package com.ecommerce.posgrado.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author gclaure Gustavo Claure Flores Date: 5/20/23 Time: 22:19 Project Name: posgrado
 */
public class AppHandleException extends RuntimeException {

  @Getter
  private final HttpStatus status;

  public AppHandleException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }

}
