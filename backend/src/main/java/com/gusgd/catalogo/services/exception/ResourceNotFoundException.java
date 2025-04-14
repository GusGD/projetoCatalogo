package com.gusgd.catalogo.services.exception;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message){
    super(message);
  }
}
