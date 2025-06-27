package com.gusgd.catalogo.services;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.gusgd.catalogo.dto.ProductDTO;
import com.gusgd.catalogo.repositories.ProductRepository;
import com.gusgd.catalogo.services.exception.ResourceDataBaseException;
import com.gusgd.catalogo.services.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class ProductServiceIT {
  
  @Autowired
  private ProductService service;

  @Autowired
  private ProductRepository repository;

  private Long existingId;
  private Long nonExistingId;
  private Long countTotalProducts;
  private Long dependentId;


  @BeforeEach
  void setUp() throws Exception{
    existingId = 41L;
    nonExistingId = 1000L;
    countTotalProducts = 41L;
    dependentId = 1L;
  }
  
  @Test
  public void deleteShouldDeleteResourceWhenIdExists(){
    service.delete(existingId);
    Assertions.assertEquals(countTotalProducts - 1, repository.count());
  }

  @Test
  public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist(){
    Assertions.assertThrows(ResourceNotFoundException.class, () -> {
      service.delete(nonExistingId);
    });
  }

  @Test
	public void deleteShouldThrowResourceDataBaseExceptionWhenDependentId(){
		Assertions.assertThrows(ResourceDataBaseException.class, ()->{
			service.delete(dependentId);
		});
  }

  @Test
  public void findAllPagedShouldReturnPageWhenPage0size10(){
    PageRequest pageRequest = PageRequest.of(0,10);
    Page<ProductDTO> result = service.findAllPaged(pageRequest);

    Assertions.assertFalse(result.isEmpty());
    Assertions.assertEquals(0, result.getNumber());
    Assertions.assertEquals(10, result.getSize());
    Assertions.assertEquals(countTotalProducts, result.getTotalElements());

  }

  @Test
  public void findAllPagedShouldReturnEmptyWhenPagedDoesNotExist(){
    PageRequest pageRequest = PageRequest.of(10,10);
    Page<ProductDTO> result = service.findAllPaged(pageRequest);

    Assertions.assertTrue(result.isEmpty());
  }

  @Test
  public void findAllPagedShouldReturnSortedPageWhenSortByName() {
    PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("name"));
    Page<ProductDTO> result = service.findAllPaged(pageRequest);

    Assertions.assertFalse(result.isEmpty());

    List<String> names = result.getContent()
                              .stream()
                              .map(ProductDTO::getName)
                              .toList();

    Collator collator = Collator.getInstance(Locale.of("pt", "BR"));
    collator.setStrength(Collator.PRIMARY);
    List<String> sorted = new ArrayList<>(names);
    sorted.sort(collator::compare);
    Assertions.assertEquals(sorted, names);
  }

}
