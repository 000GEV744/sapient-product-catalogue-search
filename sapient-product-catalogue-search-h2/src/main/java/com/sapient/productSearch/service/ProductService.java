package com.sapient.productSearch.service;

import java.util.List;
import java.util.Optional;

import com.sapient.productSearch.dto.ProductDto;
import com.sapient.productSearch.dto.SellerDto;
import com.sapient.productSearch.entity.Product;

public interface ProductService {
	List<ProductDto> listAllProducts();
	ProductDto getByProductName(String productName);
	List<ProductDto> getBybrand(String brand);
	ProductDto getById(int id);
	List<ProductDto> getBySize(int size);
	void deleteByProductName(String productName);
//	ProductDto saveAndUpdateProduct(Product product);
	SellerDto sellerInfoByProductName(String productName);
	List<ProductDto> getAllProductByCategory(String categoryName);
	List<ProductDto> getAllProductSellingBySeller(String seller);
}
