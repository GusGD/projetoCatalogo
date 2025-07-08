package com.gusgd.catalogo.dto;

import java.io.Serializable;

import com.gusgd.catalogo.entities.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CategoryDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;

  public CategoryDTO(Category entity) {
    this.id = entity.getId();
    this.name = entity.getName();
  }
}
