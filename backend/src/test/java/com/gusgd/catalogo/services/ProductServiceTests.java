package com.gusgd.catalogo.services;

import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gusgd.catalogo.entities.Category;
import com.gusgd.catalogo.entities.Product;
import com.gusgd.catalogo.repositories.ProductRepository;
import com.gusgd.catalogo.services.exception.ResourceDataBaseException;
import com.gusgd.catalogo.services.exception.ResourceNotFoundException;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {
  
  @InjectMocks
  private ProductService service;
  @Mock
  private ProductRepository repository;

  private long existingId;
  private long nonExistingId;
  private long dependentId;

	@BeforeEach
	void setUp() {
		existingId = 1L;
		nonExistingId = 10000L;
		dependentId = 2L;


		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(Mockito.mock(Product.class)));
		Mockito.doNothing().when(repository).delete(Mockito.any());
		Mockito.when(repository.existsById(existingId)).thenReturn(true);

		Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
		Mockito.when(repository.existsById(nonExistingId)).thenReturn(false);

    Product dependentProduct = Mockito.mock(Product.class);
    Mockito.when(dependentProduct.getCategories()).thenReturn(Set.of(Mockito.mock(Category.class)));
    Mockito.when(repository.findById(dependentId)).thenReturn(Optional.of(dependentProduct));
	}

	@Test
	public void deleteShouldDoNothingWhenIdExists() {
			Assertions.assertDoesNotThrow(() -> {
					service.delete(existingId);
			});

    Mockito.verify(repository, Mockito.times(1)).delete(Mockito.any(Product.class));
	}

	@Test
	public void deleteShouldResourceNotFoundExceptionWhenIdDoesNotExist(){
		Assertions.assertThrows(ResourceNotFoundException.class, ()->{
			service.delete(nonExistingId);
		});
	}

	@Test
	public void deleteShouldThrowResourceDataBaseExceptionWhenDependentId(){
		Assertions.assertThrows(ResourceDataBaseException.class, ()->{
			service.delete(dependentId);
		});
	}
}