package com.gusgd.catalogo.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gusgd.catalogo.dto.CategoryDTO;
import com.gusgd.catalogo.services.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
  
  private final CategoryService service;
  
  @GetMapping
  public ResponseEntity<List<CategoryDTO>> findAll(){
      List<CategoryDTO> list = service.findAll();
      return ResponseEntity.ok().body(list);
  }
}
