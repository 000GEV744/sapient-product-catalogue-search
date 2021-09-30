package com.sapient.productSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.productSearch.dto.ProductDto;
import com.sapient.productSearch.dto.SellerDto;
import com.sapient.productSearch.exception.NotFoundException;
import com.sapient.productSearch.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public List<ProductDto> getAllProduct() {
		return productService.listAllProducts();
	}
	
	@GetMapping("/sellerInfo/{productName}")
	public SellerDto getSellerInfoByProductName(@PathVariable String productName) {
		SellerDto sellerDto = productService.sellerInfoByProductName(productName);
		if(sellerDto == null) {
			throw new NotFoundException("Product not found with product name - "+productName);
		}
		return sellerDto;
	}
	
	@GetMapping("/getByCategory/{categoryName}")
	public List<ProductDto> getAllProductByCategory(@PathVariable String categoryName){
		List<ProductDto> productList = productService.getAllProductByCategory(categoryName);
		if(productList == null) {
			throw new NotFoundException("Product Not Found with Category name - "+categoryName);
		}
		return productList;
	}

	@GetMapping("/getBySellerName/{seller}")
	public List<ProductDto> getAllProductSellingBySeller(@PathVariable String seller){
		List<ProductDto> productList = productService.getAllProductSellingBySeller(seller);
		if(productList == null) {
			throw new NotFoundException("Product Not Found with Seller name - "+seller);
		}
		return productList;
	}
	
	@GetMapping("/getByname/{productName}")
	public ProductDto getByProductName(@PathVariable String productName) {
		ProductDto product = productService.getByProductName(productName);
		if(product == null) {
			throw new NotFoundException("Product Not Found with name - "+productName);
		}
		return product;
	}

	@GetMapping("/getById/{id}")
	public ProductDto getProductById(@PathVariable int id) {
		ProductDto product = productService.getById(id);
		if(product == null) {
			throw new NotFoundException("Product Not Found with name - "+id);
		}
		return product;
	}

	@GetMapping("/getBySize/{size}")
	public List<ProductDto> getProductBySize(@PathVariable int size) {
		List<ProductDto> productList = productService.getBySize(size);
		if(productList == null) {
			throw new NotFoundException("Product Not Found with size - "+size);
		}
		return productList;
	}

	@GetMapping("/getByBrand/{brand}")
	public List<ProductDto> getProductByBrand(@PathVariable String brand) {
		List<ProductDto> productList = productService.getBybrand(brand);
		if(productList == null) {
			throw new NotFoundException("Product Not Found with brand - "+brand);
		}
		return productList;
	}	

	@DeleteMapping("/{productName}")
	public void deleteByProductName(@PathVariable String productName) {
		productService.deleteByProductName(productName);
	}

}
