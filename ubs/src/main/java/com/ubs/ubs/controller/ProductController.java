package com.ubs.ubs.controller;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ubs.ubs.model.Inventory;
import com.ubs.ubs.model.Product;
import com.ubs.ubs.model.Warehouse;
import com.ubs.ubs.repository.GoodinRepository;
import com.ubs.ubs.repository.ProductRepository;
import com.ubs.ubs.repository.WarehouseRepository;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired 
	WarehouseRepository warehouseRepository;
	
	@GetMapping(value = "/findProduct",
				params = {"id"})
	public Product getProductById(@RequestParam("id") int id) {
		return productRepository.findById(id);
	}
	
	@PostMapping(value = "/insertProduct")
	public  ResponseEntity<Product> setProduct(@RequestBody Product p) {
		productRepository.save(p);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	
}
