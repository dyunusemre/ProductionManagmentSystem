package com.ubs.ubs.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.ubs.model.Goodin;
import com.ubs.ubs.model.Inventory;
import com.ubs.ubs.model.Product;
import com.ubs.ubs.model.Warehouse;
import com.ubs.ubs.repository.InventoryRepository;
import com.ubs.ubs.repository.ProductRepository;
import com.ubs.ubs.repository.WarehouseRepository;


@RestController
@RequestMapping(value = "/good_in")
public class GoodinController {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	WarehouseRepository warehouseRepository;
	@Autowired
	InventoryRepository inventoryRepository;
	
	
	@PostMapping(value = "/insertGoods")
	public  ResponseEntity<Goodin> setProduct(@RequestBody Goodin g,@RequestParam int p_id,@RequestParam int w_id) {
		Product p = productRepository.findById(p_id);
		Warehouse w = warehouseRepository.findById(w_id);
		System.out.println(org.hibernate.Version.getVersionString());
		Inventory i = new Inventory();
		i.setProduct(p);
		i.setWarehouse(w);
		i.setQty(400);
		
		inventoryRepository.save(i);
		System.out.println(i.getQty());
		return new ResponseEntity<Goodin>(g,HttpStatus.OK);
	}
}
