package com.portal.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.ecommerce.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductName(String productName);

	Product findByProductId(long productId);

}
