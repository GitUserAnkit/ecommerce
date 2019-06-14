package com.portal.ecommerce.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.ecommerce.entity.Product;
import com.portal.ecommerce.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ProductController.class,secure = false)
//@SpringBootTest
//@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ProductService productService;

	@Test
	public void createProduct() throws Exception {
		Mockito.when(productService.insertProduct(Matchers.anyObject())).thenReturn(new Product());
		mvc.perform(MockMvcRequestBuilders.post("/e-commerce/product").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(new Product())))
				.andExpect(status().isOk());
				//andExpect(content().string(equalTo("Like to get sucess!")));
		
	}
	  @Test
	  public void searchProduct() throws Exception {
		  Mockito.when(productService.searchProductById(Matchers.anyString())).thenReturn("football");
	        mvc.perform(MockMvcRequestBuilders.get("/e-commerce/product/football").accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(content().string(equalTo("football")));
}}