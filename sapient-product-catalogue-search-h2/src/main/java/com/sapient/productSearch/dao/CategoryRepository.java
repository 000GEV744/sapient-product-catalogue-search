package com.sapient.productSearch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.productSearch.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String categoryName);
	
	List<Category> findAll();
}
