package com.gusgd.catalogo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gusgd.catalogo.entities.Category;
import com.gusgd.catalogo.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
    
    private final CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }
    
}
