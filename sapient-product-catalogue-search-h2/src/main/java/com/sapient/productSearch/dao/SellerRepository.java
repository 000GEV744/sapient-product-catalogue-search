package com.sapient.productSearch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.productSearch.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

	Seller findBysellerName(String sellerName);
	List<Seller> findAll();

}
