package com.gusgd.catalogo.services;

public class ForbiddenException extends RuntimeException {
  public ForbiddenException(String message){
    super(message);
  }
}
