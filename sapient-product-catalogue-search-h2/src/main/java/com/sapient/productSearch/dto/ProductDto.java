package com.sapient.productSearch.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.sapient.productSearch.entity.Category;
import com.sapient.productSearch.entity.Seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private String productName;
	private long price;
	private String brand;
	private int quantity;
	private int size;
	

}
