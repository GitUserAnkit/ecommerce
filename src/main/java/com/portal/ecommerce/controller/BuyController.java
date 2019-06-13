package com.portal.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.ecommerce.service.Buyservice;

@RestController
@RequestMapping("product")
public class BuyController {
	
	@Autowired
	private Buyservice buyService;
	
	@PostMapping("/buy/{productId}")
	public String buyProduct(@PathVariable long productId) {
		return buyService.placeOrder(productId);
	}

}
