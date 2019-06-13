package com.portal.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.ecommerce.entity.Product;
import com.portal.ecommerce.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product insertProduct(Product product) {
		Product product1=productRepository.save(product);
		return product1;
	}

	@Override
	public String searchProductById(String productName) {
		
		
		Product product2=productRepository.findByProductName(productName);
		if(product2!=null) {
		
		return "Your reuested product name-"+product2.getProductName()+" , price-"+ product2.getPrice()+" and rating-"+product2.getRating();
	}
		else {
			return "Product is not available";
		}
	}

}
