package com.gusgd.catalogo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<CategoryDTO> findAll(String name, Pageable pageable){
			Page<Category> list = repository.searchByName(name,pageable);
			return list.map(CategoryDTO::new);
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id){
		Category category = repository.findById(id)
		                    .orElseThrow(()-> new ResourceNotFoundException("Category not found."));
		return new CategoryDTO(category);
	}

	@Transactional()
	public CategoryDTO insert(CategoryDTO dto){
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}

	@Transactional()
	public CategoryDTO update(Long id, CategoryDTO dto){
		Category entity = repository.findById(id)
		                            .orElseThrow(() -> new ResourceNotFoundException("Category not found."));
		entity.setName(dto.getName());
		return new CategoryDTO(entity);
	}

	public void delete(Long id){
		Category entity = repository.findById(id)
																.orElseThrow(() -> new ResourceNotFoundException("Category not found. ID: " + id));
		repository.delete(entity);
	}
}
