package com.gusgd.catalogo.services.exception;

public class ResourceDataBaseException extends RuntimeException {
  public ResourceDataBaseException(String message){
    super(message);
  }
  public ResourceDataBaseException(String message, Throwable cause) {
    super(message, cause);
  }
}
