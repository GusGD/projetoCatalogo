package com.gusgd.catalogo.dto;

import java.util.ArrayList;
import java.util.List;

import com.gusgd.catalogo.entities.Category;
import com.gusgd.catalogo.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

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

  public ProductDTO() {
  }

  public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgUrl = imgUrl;
  }

  public ProductDTO(Product entity) {
    id = entity.getId();
    name = entity.getName();
    description = entity.getDescription();
    price = entity.getPrice();
    imgUrl = entity.getImgUrl();
    for (Category cat : entity.getCategories()) {
      categories.add(new CategoryDTO(cat));
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public List<CategoryDTO> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryDTO> categories) {
    this.categories.clear();
    if (categories != null) {
      this.categories.addAll(categories);
    }
  }
}
