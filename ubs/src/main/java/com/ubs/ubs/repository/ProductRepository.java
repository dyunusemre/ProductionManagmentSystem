package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	Product findById(int i);

}
