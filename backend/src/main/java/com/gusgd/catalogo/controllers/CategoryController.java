package com.gusgd.catalogo.controllers;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gusgd.catalogo.dto.CategoryDTO;
import com.gusgd.catalogo.services.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RequiredArgsConstructor
@RestController
@RequestMapping(value="/categories")
public class CategoryController {
  
  private final CategoryService service;
  
  @GetMapping
  public ResponseEntity<Page<CategoryDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name, Pageable pageable){
    Page<CategoryDTO> list = service.findAll(name, pageable);
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity <CategoryDTO> findById(@PathVariable Long id){
    CategoryDTO dto = service.findById(id);
    return ResponseEntity.ok().body(dto);
  }

  @PostMapping()
  public ResponseEntity <CategoryDTO> insert(@Valid @RequestBody CategoryDTO dto) {
    dto = service.insert(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                                        .buildAndExpand(dto.getId()).toUri();      
    return ResponseEntity.created(uri).body(dto);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity <CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
    dto = service.update(id, dto);
    return ResponseEntity.ok(dto);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity <CategoryDTO> update(@PathVariable Long id) {
    service.delete(id);      
    return ResponseEntity.noContent().build();
  }
  
}
