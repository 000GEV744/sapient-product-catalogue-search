package com.sapient.productSearch;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sapient.productSearch.controller.ProductController;
import com.sapient.productSearch.dto.ProductDto;
import com.sapient.productSearch.service.ProductService;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ModelMapper mapper;
	
	@MockBean
	ProductService productService;
	
	ProductDto product1 = new ProductDto("X-Ray Lite Unisex Shoes", 3569l, "Puma", 20, 8);
	ProductDto product2 = new ProductDto("FAST PRIMEBLUE TEE", 3299l, "Adidas", 34, 32);
	ProductDto product3 = new ProductDto("Olive Green Camouflage casual shirt", 974l, "Roadster", 25, 38);
	
	@Test
	public void getAllProduct() throws Exception {
		List<ProductDto> products = new ArrayList<>(Arrays.asList(product1, product2, product3));
		Mockito.when(productService.listAllProducts()).thenReturn(products);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/products/")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(3)))
				.andExpectAll(jsonPath("$[1].productName", Matchers.is("FAST PRIMEBLUE TEE")));
				
	}
	
	@Test
	public void getByProductName() throws Exception {
		Mockito.when(productService.getByProductName(product1.getProductName())).thenReturn(product1);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/products/getByname/X-Ray Lite Unisex Shoes")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", notNullValue()))
				.andExpectAll(jsonPath("$.productName", Matchers.is("X-Ray Lite Unisex Shoes")));
				
	}
	

}
