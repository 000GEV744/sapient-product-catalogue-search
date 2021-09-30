package com.sapient.productSearch.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.productSearch.dao.CategoryRepository;
import com.sapient.productSearch.dto.CategoryDto;
import com.sapient.productSearch.dto.ProductDto;
import com.sapient.productSearch.dto.SellerDto;
import com.sapient.productSearch.entity.Category;
import com.sapient.productSearch.entity.Product;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<CategoryDto> findAll() {
		return categoryRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	private CategoryDto convertToDto(Category category) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CategoryDto categoryDto = mapper.map(category, CategoryDto.class);
		return categoryDto;
	}

}
