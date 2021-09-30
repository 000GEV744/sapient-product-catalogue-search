package com.sapient.productSearch.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.productSearch.dao.CategoryRepository;
import com.sapient.productSearch.dao.ProductRepository;
import com.sapient.productSearch.dao.SellerRepository;
import com.sapient.productSearch.dto.ProductDto;
import com.sapient.productSearch.dto.SellerDto;
import com.sapient.productSearch.entity.Category;
import com.sapient.productSearch.entity.Product;
import com.sapient.productSearch.entity.Seller;
import com.sapient.productSearch.exception.NotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<ProductDto> listAllProducts(){
		List<Product> allProducts = productRepo.findAll();
		if(allProducts != null) {
			List<ProductDto> allProductDto = allProducts.stream()
			.map(this::convertToDto)
			.collect(Collectors.toList());
			return allProductDto;
		}
		return null;
	}
	
	@Override
	public ProductDto getByProductName(String productName) {
		// TODO Auto-generated method stub
		Optional<Product> product =  productRepo.findByProductName(productName);
		if(product.isPresent()) {
			return this.convertToDto(product.get());
		}
		return null;
	}


	@Override
	public List<ProductDto> getBybrand(String brand) {
		// TODO Auto-generated method stub
		Optional<List<Product>> optional =  productRepo.findBybrand(brand);
		if(optional.isPresent()) {
			return optional.get().stream().map(this::convertToDto).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public ProductDto getById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> product =  productRepo.findById(id);
		if(product.isPresent()) {
			return this.convertToDto(product.get());
		}
		return null;
	}

	@Override
	public List<ProductDto> getBySize(int size) {
		// TODO Auto-generated method stub
		Optional<List<Product>> product =  productRepo.findBySize(size);
		if(product.isPresent()) {
			return product.get().stream().map(this::convertToDto).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public void deleteByProductName(String productName) {
		// TODO Auto-generated method stub
		productRepo.deleteByProductName(productName);
	}
	
	/*
	 * @Override public ProductDto saveAndUpdateProduct(Product product) { return
	 * this.convertToDto(productRepo.save(product)); }
	 */
	
	@Override
	public SellerDto sellerInfoByProductName(String productName) {
		Optional<Product> product =  productRepo.findByProductName(productName);
		if(product.isPresent()) {
			Seller seller = product.get().getSeller();
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			SellerDto sellerDto = mapper.map(seller, SellerDto.class);
			return sellerDto;
		}
		return null;
	}
	
	@Override
	public List<ProductDto> getAllProductByCategory(String categoryName){
		Category category = categoryRepo.findByCategoryName(categoryName);
//		System.out.println("Category"+category);
		if(category != null) {
			return category.getProducts().stream().map(this::convertToDto).collect(Collectors.toList());
		}
		else {
			throw new NotFoundException("No Category found with name "+categoryName);
		}
	}
	
	@Override
	public List<ProductDto> getAllProductSellingBySeller(String sellerName) {
		Seller seller = sellerRepo.findBysellerName(sellerName);
		if(seller != null) {
			return seller.getProduct().stream().map(this::convertToDto).collect(Collectors.toList());
		}
		else {
			throw new NotFoundException("No Seller found with name "+sellerName);
		}
	}
	
	private ProductDto convertToDto(Product product) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDto productDto = mapper.map(product, ProductDto.class);
		return productDto;
	}

}
