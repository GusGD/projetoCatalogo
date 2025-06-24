package com.gusgd.catalogo.tests;

import com.gusgd.catalogo.dto.ProductDTO;
import com.gusgd.catalogo.entities.Category;
import com.gusgd.catalogo.entities.Product;

public class Factory {
  
  public static Product createProduct(){
    Product product = new Product(1L,"phone", "Good Phone", 800.00, "null");
    product.getCategories().add(new Category(1L,"Eletronics"));
    return product;
  }

  public static ProductDTO createProductDTO(){
    Product product = createProduct();
    return new ProductDTO(product);
  }
}
