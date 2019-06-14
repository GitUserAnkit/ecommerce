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

import com.portal.ecommerce.service.CartService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CartController.class, secure = false)
// @SpringBootTest
// @AutoConfigureMockMvc
public class CartControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private CartService cartService;

	@Test
	public void addProductToCart() throws Exception {
		Mockito.when(cartService.addToCart(Matchers.anyLong())).thenReturn("2");
		  mvc.perform(MockMvcRequestBuilders.post("/product/cart/2").accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().string(equalTo("2")));
}}
	