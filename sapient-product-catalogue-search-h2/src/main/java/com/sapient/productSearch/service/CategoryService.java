package com.sapient.productSearch.service;

import java.util.List;

import com.sapient.productSearch.dto.CategoryDto;

public interface CategoryService {
	List<CategoryDto> findAll();
}
