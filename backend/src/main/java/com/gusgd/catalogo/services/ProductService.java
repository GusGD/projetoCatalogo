package com.gusgd.catalogo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gusgd.catalogo.dto.CategoryDTO;
import com.gusgd.catalogo.dto.ProductDTO;
import com.gusgd.catalogo.entities.Category;
import com.gusgd.catalogo.entities.Product;
import com.gusgd.catalogo.repositories.ProductRepository;
import com.gusgd.catalogo.services.exception.ResourceDataBaseException;
import com.gusgd.catalogo.services.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
  private final ProductRepository repository;

  @Transactional(readOnly = true)
  public ProductDTO findById(Long id){
    Product product = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found. ID: " + id));
    return new ProductDTO(product);
  }

  @Transactional(readOnly = true)
  public Page<ProductDTO> findAll(String name, Pageable pageable){
    Page<Product> result = repository.searchByName(name,pageable);
    return result.map(ProductDTO::new);
  }

  @Transactional(readOnly = true)
  public Page<ProductDTO> findAllPaged(Pageable pageable){
    Page<Product> result = repository.findAll(pageable);
    return result.map(ProductDTO::new);
  }


  @Transactional()
  public ProductDTO insert(ProductDTO dto){
    Product entity = new Product();
    copyDtoToEntity(dto,entity);
    entity = repository.save(entity);
    return new ProductDTO(entity);
  }

  @Transactional()
  public ProductDTO update(Long id, ProductDTO dto){
      Product entity = repository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found. ID: " + id));
      copyDtoToEntity(dto, entity);
      entity = repository.save(entity);
      return new ProductDTO(entity);

  }

@Transactional(propagation = Propagation.REQUIRED)
public void delete(Long id) {
  try {
    Product entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product not found. ID: " + id));

    if (!entity.getCategories().isEmpty())
        throw new ResourceDataBaseException("Cannot delete product with id " + id + 
                                            " because it is referenced by one or more categories.");
    repository.delete(entity);

  } catch (ResourceDataBaseException e) {
      throw new ResourceDataBaseException("Cannot delete product with id " + id + 
                                          " due to database integrity constraints.");
  }
}
  private void copyDtoToEntity(ProductDTO dto, Product entity) {
    entity.setName(dto.getName());
    entity.setDescription(dto.getDescription());
    entity.setPrice(dto.getPrice());
    entity.setImgUrl(dto.getImgUrl());
    entity.getCategories().clear();
    for (CategoryDTO catDTO : dto.getCategories()){
      Category cat = new Category();
      cat.setId(catDTO.getId());
      entity.getCategories().add(cat);
    }
  }
}
