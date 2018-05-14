package com.ubs.ubs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ubs.ubs.model.Product;
import com.ubs.ubs.repository.ProductRepository;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/findProduct")
	public @ResponseBody Optional<Product> getProductById(@RequestParam("id") int id) {
		return productRepository.findById(id);
	}
	
}
