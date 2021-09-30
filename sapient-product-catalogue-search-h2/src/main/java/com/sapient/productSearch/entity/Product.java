package com.sapient.productSearch.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "product_name")
	private String productName;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "size")
	private int size;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	
}
