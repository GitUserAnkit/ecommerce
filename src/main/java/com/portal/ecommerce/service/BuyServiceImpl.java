package com.portal.ecommerce.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.ecommerce.entity.Buy;
import com.portal.ecommerce.entity.Product;
import com.portal.ecommerce.repository.BuyRepository;
import com.portal.ecommerce.repository.ProductRepository;

@Service
public class BuyServiceImpl implements Buyservice {
	
	@Autowired
	private ProductRepository productRepository;

	
	@Autowired
	private BuyRepository buyRepository;
	

	@Override
	public String placeOrder(long productId) {
		
		Product product4= productRepository.findByProductId(productId);
		Buy buy=new Buy();
		buy.setDate(new Date());
		buy.setTransactionId(987654321);
		buy.setProduct(product4);
		buyRepository.save(buy);
		
		
		
		
		
		
		 return "Order Placed successfully";
	 
	}

}
