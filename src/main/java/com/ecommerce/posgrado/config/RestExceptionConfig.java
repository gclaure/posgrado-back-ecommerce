package com.ecommerce.posgrado.config;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.ecommerce.posgrado.exception.AppHandleException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.sasl.AuthenticationException;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 22:26 Project Name: posgrado
 */
@ControllerAdvice
public class RestExceptionConfig {

  @ExceptionHandler(value = {AppHandleException.class})
  @ResponseBody
  public ResponseEntity<?> handleException(AppHandleException exception) {
    Map<String, Object> error = new HashMap<>();
    error.put("status", false);
    error.put("message", exception.getMessage());
    error.put("time", LocalDateTime.now());
    return new ResponseEntity<>(error, exception.getStatus());
  }

  @ExceptionHandler(SignatureVerificationException.class)
  @ResponseBody
  public ResponseEntity<?> handleSignatureVerificationException(Exception exception) {
    Map<String, Object> error = new HashMap<>();
    error.put("status", false);
    error.put("message", exception.getMessage());
    error.put("time", LocalDateTime.now());
    return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(AuthenticationException.class)
  @ResponseBody
  public ResponseEntity<?> handleAuthenticationException(Exception exception) {
    Map<String, Object> error = new HashMap<>();
    error.put("status", false);
    error.put("message", exception.getMessage());
    error.put("time", LocalDateTime.now());
    return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public ResponseEntity<?> handleUnsupportedMediaTypeException(MethodArgumentNotValidException methodArgumentNotValidException) {
    Map<String, Object> error = new HashMap<>();
    ArrayList<String> messages = new ArrayList<>();
    for (int i = 0; i < methodArgumentNotValidException.getAllErrors().toArray().length; i++) {
      messages.add(methodArgumentNotValidException.getAllErrors().get(i).getDefaultMessage());
    }
    error.put("status", false);
    error.put("message", messages);
    error.put("time", LocalDateTime.now());
    return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(AccessDeniedException.class)
  @ResponseBody
  public ResponseEntity<?> exceptionAccessDenied(AccessDeniedException exception) {
    Map<String, Object> error = new HashMap<>();
    error.put("status", false);
    error.put("message", exception.getMessage());
    error.put("time", LocalDateTime.now());
    return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
  }


}
