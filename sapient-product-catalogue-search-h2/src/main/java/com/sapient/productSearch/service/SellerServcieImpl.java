package com.sapient.productSearch.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.productSearch.dao.CategoryRepository;
import com.sapient.productSearch.dao.SellerRepository;
import com.sapient.productSearch.dto.CategoryDto;
import com.sapient.productSearch.dto.SellerDto;
import com.sapient.productSearch.entity.Category;
import com.sapient.productSearch.entity.Seller;

@Service
@Transactional
public class SellerServcieImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepo;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<SellerDto> findAll() {
		return sellerRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	private SellerDto convertToDto(Seller seller) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		SellerDto sellerDto = mapper.map(seller, SellerDto.class);
		return sellerDto;
	}

}
