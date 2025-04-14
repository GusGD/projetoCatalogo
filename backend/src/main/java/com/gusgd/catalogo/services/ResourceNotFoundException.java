package com.gusgd.catalogo.services;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message){
    super(message);
  }
}
