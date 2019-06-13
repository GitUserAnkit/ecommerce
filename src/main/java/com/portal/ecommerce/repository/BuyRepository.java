package com.portal.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.ecommerce.entity.Buy;
@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {

}
