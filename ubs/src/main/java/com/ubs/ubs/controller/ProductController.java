package com.ubs.ubs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ubs.ubs.model.Product;
import com.ubs.ubs.repository.InventoryRepository;
import com.ubs.ubs.repository.ProductRepository;
import com.ubs.ubs.repository.WarehouseRepository;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired 
	WarehouseRepository warehouseRepository;
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/findProduct",
				params = {"id"})
	public @ResponseBody Product getProductById(@RequestParam("id") int id) {
		return productRepository.findById(id);
	}
	
	@CrossOrigin(allowCredentials="true")
	@PostMapping(value = "/insertProduct")
	public @ResponseBody ResponseEntity<Product> setProduct(@RequestBody Product p) {
		productRepository.save(p);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value="/getAllProducts")
	public @ResponseBody List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value="/deleteProduct",
			params = {"id"})
	public @ResponseBody ResponseEntity<Product> deleteProductId(@RequestParam("id") int id) {
		if(productRepository.existsById(id)){
			Product p = new Product(productRepository.getOne(id));
			productRepository.deleteById(id);
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	
	
}
