package com.portal.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.ecommerce.service.CartService;

@RestController
@RequestMapping("/product")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart/{productId}")
	public String addProductToCart(@PathVariable long productId) {
		return cartService.addToCart(productId);
	}

}
