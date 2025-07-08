package com.gusgd.catalogo.dto;

import java.time.Instant;
import lombok.*;

@Getter
@RequiredArgsConstructor
public class CustomError {
  private final Instant timestamp;
  private final Integer status;
  private final String error;
  private final String path;
}
