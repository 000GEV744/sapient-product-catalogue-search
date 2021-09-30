package com.sapient.productSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.productSearch.dto.SellerDto;
import com.sapient.productSearch.service.SellerService;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/")
	public List<SellerDto> findAll() {
		return sellerService.findAll();
	}
}
