package com.portal.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.ecommerce.entity.Product;
import com.portal.ecommerce.service.ProductService;

@RestController
@RequestMapping("/e-commerce")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
	}
	
	@GetMapping("/product/{productName}")
	public String searchProduct(@PathVariable String productName) {
		return productService.searchProductById(productName);
	}

}
