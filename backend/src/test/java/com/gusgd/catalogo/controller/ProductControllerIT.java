package com.gusgd.catalogo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gusgd.catalogo.dto.ProductDTO;
import com.gusgd.catalogo.tests.Factory;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductControllerIT {
  	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

  private Long existingId;
  private Long nonExistingId;
  private Long countTotalProducts;
  private Long dependentId;
  private int page;
  private int size;
  private String sort;

  @BeforeEach
  void setUp() throws Exception{
    existingId = 41L;
    nonExistingId = 1000L;
    countTotalProducts = 41L;
    dependentId = 1L;
    page = 0;
    size = 41;
    sort = "name,asc";
  }

  @Test
  public void findAllShouldReturnSortedPageWhenSortByName() throws Exception{
    ResultActions resultActions = mockMvc.perform(
    get("/products?page={page}&size={size}&sort={sort}", page, size, sort)
        .accept(MediaType.APPLICATION_JSON));
    resultActions.andExpect(status().isOk());
    resultActions.andExpect(jsonPath("$.content").exists());
    resultActions.andExpect(jsonPath("$.totalElements").value(countTotalProducts));

    MvcResult mvcResult = resultActions.andReturn();
    String json = mvcResult.getResponse().getContentAsString();
    objectMapper = new ObjectMapper();
    JsonNode root = objectMapper.readTree(json);
    JsonNode content = root.path("content");

    List<String> names = new ArrayList<>();
    for (JsonNode node : content){
      names.add(node.path("name").asText());
    }

    Collator collator = Collator.getInstance(Locale.of("pt", "BR"));
    collator.setStrength(Collator.PRIMARY);

    List<String> sorted = new ArrayList<>(names);
    sorted.sort(collator::compare);

    Assertions.assertEquals(sorted, names);
  }

  @Test
	public void updateShouldReturnProductDTOWhenIdExists() throws Exception{
    ProductDTO productDTO = Factory.createProductDTO();
		String jsonBody = objectMapper.writeValueAsString(productDTO);

    String expectedName = productDTO.getName();
    String expectedDescription = productDTO.getDescription();
    Double expectedPrice = productDTO.getPrice();

		mockMvc.perform(put("/products/{id}", existingId)
		 		   .content(jsonBody)
					 .contentType(MediaType.APPLICATION_JSON)
					 .accept(MediaType.APPLICATION_JSON))
					 .andExpect(status().isOk())
					 .andExpect(jsonPath("$.id").value(existingId))
					 .andExpect(jsonPath("$.name").value(expectedName))
					 .andExpect(jsonPath("$.description").value(expectedDescription))
					 .andExpect(jsonPath("$.price").value(expectedPrice));
	}

  @Test
	public void updateShouldReturnNotFoundWhenIdDOesNotExists() throws Exception{
    ProductDTO productDTO = Factory.createProductDTO();
		String jsonBody = objectMapper.writeValueAsString(productDTO);

		mockMvc.perform(put("/products/{id}", nonExistingId)
		 		   .content(jsonBody)
					 .contentType(MediaType.APPLICATION_JSON)
					 .accept(MediaType.APPLICATION_JSON))
					 .andExpect(status().isNotFound());
	}
}
