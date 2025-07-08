package com.gusgd.catalogo.dto;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class FieldMessage {
  private final String fieldName;
  private final String message;
}
