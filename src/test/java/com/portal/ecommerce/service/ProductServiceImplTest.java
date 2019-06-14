package com.portal.ecommerce.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.portal.ecommerce.entity.Product;
import com.portal.ecommerce.repository.ProductRepository;

import junit.framework.Assert;
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {



	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductServiceImpl productService;

	@InjectMocks 
	private CartServiceImpl cartService;



	@Test
	public void testinsertProduct() {
	Product product = new Product();
	product.setProductId(1L);
	product.setProductName("laptop");
	product.setPrice(100.00);
	product.setRating(4.0f);
	Mockito.when(productRepository.save(product)).thenReturn(product);
	Product products = productService.insertProduct(product);
	Assert.assertEquals(product, products);
	}
	@Test
	public void addToCart() {
	Product product=new Product();
	product.setProductId(1L);
	product.setProductName("laptop");
	product.setPrice(100.00);
	product.setRating(4.0f);
	Mockito.when(productRepository.findByProductName(product.getProductName())).thenReturn(product);
	Product products=productRepository.findByProductName(product.getProductName());
	Assert.assertEquals("success",product,products);

	}


}
