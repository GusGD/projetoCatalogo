package com.gusgd.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gusgd.catalogo.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
