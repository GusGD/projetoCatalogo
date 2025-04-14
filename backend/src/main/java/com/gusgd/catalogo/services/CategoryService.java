package com.gusgd.catalogo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gusgd.catalogo.dto.CategoryDTO;
import com.gusgd.catalogo.entities.Category;
import com.gusgd.catalogo.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
	
	private final CategoryRepository repository;

	public List<CategoryDTO> findAll(){
			List<Category> list = repository.findAll();
			return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
}
