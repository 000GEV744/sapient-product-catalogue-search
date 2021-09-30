package com.sapient.productSearch.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sapient.productSearch.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findAll();
	Optional<Product> findByProductName(String productName);
	
	/*
	 * @Query("select p from Product p where p.brand = :brand")
	 * Optional<List<Product>> findBybrand(@Param("brand") String brand);
	 */
	 Optional<List<Product>> findBybrand(String brand);

	Optional<Product> findById(int id);
	
	Optional<List<Product>> findBySize(int size);
	void deleteByProductName(String productName);
	
}
