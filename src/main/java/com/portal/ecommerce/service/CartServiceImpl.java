package com.portal.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.ecommerce.entity.Cart;
import com.portal.ecommerce.entity.Product;
import com.portal.ecommerce.repository.CartRepository;
import com.portal.ecommerce.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public String addToCart(long productId) {
		Product product3 = productRepository.findByProductId(productId);
		Cart cart = new Cart();
		cart.setProduct(product3);
		cartRepository.save(cart);

		return "Added to card successfully";
	}

}
