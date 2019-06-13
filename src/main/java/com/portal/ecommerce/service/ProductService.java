package com.portal.ecommerce.service;

import com.portal.ecommerce.entity.Product;

public interface ProductService {

	Product insertProduct(Product product);

	String searchProductById(String productName);

}
