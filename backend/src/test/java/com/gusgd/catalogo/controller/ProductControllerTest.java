package com.gusgd.catalogo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gusgd.catalogo.controllers.ProductController;
import com.gusgd.catalogo.dto.ProductDTO;
import com.gusgd.catalogo.services.ProductService;
import com.gusgd.catalogo.services.exception.ResourceDataBaseException;
import com.gusgd.catalogo.services.exception.ResourceNotFoundException;
import com.gusgd.catalogo.tests.Factory;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@TestConfiguration
	static class MockConfig {
			@Bean
			ProductService productService() {
					return Mockito.mock(ProductService.class);
			}
	}

	@Autowired
	private ProductService productService;
	private PageImpl<ProductDTO> page;
	private ProductDTO productDTO;
	private Long existingId;
	private Long nonExistingId;
	private Long dependentId;

	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 2L;
		dependentId = 3L;

		productDTO = Factory.createProductDTO();
		page = new PageImpl<>(List.of(productDTO));

		when(productService.findAll(null, null)).thenReturn(page);
		when(productService.findById(existingId)).thenReturn(productDTO);
		when(productService.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);

		when(productService.update(eq(existingId), any())).thenReturn(productDTO);
		when(productService.update(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);

		doNothing().when(productService).delete(existingId);
		doThrow(ResourceNotFoundException.class).when(productService).delete(nonExistingId);
		doThrow(ResourceDataBaseException.class).when(productService).delete(dependentId);
		
		when(productService.insert(any())).thenReturn(productDTO);
	}

	@Test
	public void findAllShouldReturnPage() throws Exception {
			mockMvc.perform(get("/products").accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());
	}

 @Test
	public void findByIdShouldReturnProductWhenIdExists() throws Exception {
		mockMvc.perform(get("/products/{id}", existingId)
					 .accept(MediaType.APPLICATION_JSON))
					 .andExpect(status().isOk())
					 .andExpect(jsonPath("$.id").exists())
					 .andExpect(jsonPath("$.name").exists())
					 .andExpect(jsonPath("$.description").exists())
					 .andExpect(jsonPath("$.price").exists());
	}

	@Test
	public void findByIdShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
		mockMvc.perform(get("/products/{id}", nonExistingId)
					 .accept(MediaType.APPLICATION_JSON))
					 .andExpect(status().isNotFound());
	}

	@Test
	public void updateShouldReturnProductDTOWhenIdExists() throws Exception{
		String jsonBody = objectMapper.writeValueAsString(productDTO);

		mockMvc.perform(put("/products/{id}", existingId)
		 		   .content(jsonBody)
					 .contentType(MediaType.APPLICATION_JSON)
					 .accept(MediaType.APPLICATION_JSON))
					 .andExpect(status().isOk())
					 .andExpect(jsonPath("$.id").exists())
					 .andExpect(jsonPath("$.name").exists())
					 .andExpect(jsonPath("$.description").exists())
					 .andExpect(jsonPath("$.price").exists());
	}

	@Test
	public void updateShouldReturnNotFoundProductDTOWhenIdDoesNotExists() throws Exception{
		String jsonBody = objectMapper.writeValueAsString(productDTO);
		mockMvc.perform(put("/products/{id}", nonExistingId)
		 		   .content(jsonBody)
					 .contentType(MediaType.APPLICATION_JSON)
					 .accept(MediaType.APPLICATION_JSON))
					 .andExpect(status().isNotFound());
	}
	
	@Test
	public void deleteShouldReturnNoContentWhenIdExists() throws Exception {
			mockMvc.perform(delete("/products/{id}", existingId)
							.accept(MediaType.APPLICATION_JSON))
							.andExpect(status().isNoContent());
	}

	@Test
	public void deleteShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
			mockMvc.perform(delete("/products/{id}", nonExistingId)
							.accept(MediaType.APPLICATION_JSON))
							.andExpect(status().isNotFound());
	}
	@Test
	public void deleteShouldReturnBadRequestWhenDependentId() throws Exception {
			mockMvc.perform(delete("/products/{id}", dependentId)
							.accept(MediaType.APPLICATION_JSON))
							.andExpect(status().isBadRequest());
	}

	@Test
	public void insertShouldReturnCreatedAndProductDTO() throws Exception {
			ProductDTO dto = Factory.createProductDTO();

			String jsonBody = objectMapper.writeValueAsString(dto);
			System.out.println("JSON enviado:\n" + jsonBody);

			mockMvc.perform(post("/products")
						 .content(jsonBody)
						 .contentType(MediaType.APPLICATION_JSON)
						 .accept(MediaType.APPLICATION_JSON))
						 .andExpect(status().isCreated())
						 .andExpect(jsonPath("$.id").exists())
						 .andExpect(jsonPath("$.name").value("phone"))
						 .andExpect(jsonPath("$.description").value("Good Phone"))
						 .andExpect(jsonPath("$.price").value(800.00));
	}

}
