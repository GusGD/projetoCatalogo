package com.gusgd.catalogo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gusgd.catalogo.dto.CategoryDTO;
import com.gusgd.catalogo.entities.Category;
import com.gusgd.catalogo.repositories.CategoryRepository;
import com.gusgd.catalogo.services.exception.ResourceNotFoundException;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
	
	private final CategoryRepository repository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
			List<Category> list = repository.findAll();
			return list.stream().map(CategoryDTO::new).toList();
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id){
		Category category = repository.findById(id)
		                    .orElseThrow(()-> new ResourceNotFoundException("Category not found."));
		return new CategoryDTO(category);
	}
}
