package com.gusgd.catalogo.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gusgd.catalogo.dto.CustomError;
import com.gusgd.catalogo.dto.ValidationError;
import com.gusgd.catalogo.services.ForbiddenException;
import com.gusgd.catalogo.services.ResourceDataBaseException;
import com.gusgd.catalogo.services.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
    HttpStatus status = HttpStatus.NOT_FOUND;
    CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }
  @ExceptionHandler(ResourceDataBaseException.class)
  public ResponseEntity<CustomError> databaseError(ResourceDataBaseException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<CustomError> methordArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request){
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados inválidos.", request.getRequestURI());
    for(FieldError f : e.getBindingResult().getFieldErrors()){
      err.addError(f.getField(), f.getDefaultMessage());
    }
    return ResponseEntity.status(status).body(err);
  }
  @ExceptionHandler(ForbiddenException.class)
  public ResponseEntity<CustomError> forbiddenException(ForbiddenException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.FORBIDDEN;
    CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }
}