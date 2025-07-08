package com.gusgd.catalogo.dto;

import java.util.ArrayList;
import java.util.List;

import com.gusgd.catalogo.entities.Category;
import com.gusgd.catalogo.entities.Product;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

  private Long id;

  @NotBlank(message = "Campo é de preenchimento obrigatório.")
  @Size(min = 3, message = "Campo precisa de 3 ou mais caracteres.")
  private String name;

  @NotBlank(message = "Campo é de preenchimento obrigatório.")
  @Size(min = 10, message = "Campo precisa de 10 ou mais caracteres.")
  private String description;

  @NotNull(message = "Campo requerido")
  @Positive(message = "O Preço deve ser positivo")
  private Double price;

  private String imgUrl;

  @NotEmpty(message = "Deve haver ao menos uma categoria")
  private final List<CategoryDTO> categories = new ArrayList<>();

  public ProductDTO(Product entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.price = entity.getPrice();
    this.imgUrl = entity.getImgUrl();
    for (Category cat : entity.getCategories()) {
      categories.add(new CategoryDTO(cat));
    }
  }

  public void setCategories(List<CategoryDTO> categories) {
    this.categories.clear();
    if (categories != null) {
      this.categories.addAll(categories);
    }
  }
}
