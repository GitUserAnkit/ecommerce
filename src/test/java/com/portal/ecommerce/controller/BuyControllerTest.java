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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.portal.ecommerce.service.Buyservice;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BuyController.class, secure = false)
//@ContextConfiguration("/applicationContext.xml")
// @SpringBootTest
// @AutoConfigureMockMvc
public class BuyControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private Buyservice buyService;

	@Test
	public void createProduct() throws Exception {
		
			  Mockito.when(buyService.placeOrder(Matchers.anyLong())).thenReturn("2");
		        mvc.perform(MockMvcRequestBuilders.post("/product/buy/1").accept(MediaType.APPLICATION_JSON))
		                .andExpect(status().isOk())
		                .andExpect(content().string(equalTo("2")));
	}

}