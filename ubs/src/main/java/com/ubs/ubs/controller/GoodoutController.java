package com.ubs.ubs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.ubs.model.Goodout;
import com.ubs.ubs.model.Inventory;
import com.ubs.ubs.model.InventoryId;
import com.ubs.ubs.model.Product;
import com.ubs.ubs.model.Warehouse;
import com.ubs.ubs.repository.GoodoutRepository;
import com.ubs.ubs.repository.InventoryRepository;
import com.ubs.ubs.repository.ProductRepository;
import com.ubs.ubs.repository.WarehouseRepository;

@RestController
@RequestMapping(value = "/good_out")
public class GoodoutController {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	WarehouseRepository warehouseRepository;
	@Autowired
	InventoryRepository inventoryRepository;
	@Autowired
	GoodoutRepository goodoutRepository;
	
	@CrossOrigin(allowCredentials="true")
	@PostMapping(value = "/deleteGoods")
	public @ResponseBody ResponseEntity<Goodout> setProduct(@RequestBody Goodout g) {
		Product p = productRepository.findById(g.getP_id());
		Warehouse w = warehouseRepository.findById(g.getW_id());
		System.out.println(org.hibernate.Version.getVersionString());
		if(productRepository.existsById(p.getId()) && warehouseRepository.existsById(w.getId())) {			
			if(inventoryRepository.existsById(new InventoryId(p,w))) {
				Inventory i = new Inventory();
				i.setProduct(p);
				i.setWarehouse(w);
				Inventory i2 = inventoryRepository.getOne(new InventoryId(p,w));				
				if(i2.getQty() < g.getQty()) {
					return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
				}
				i.setQty(i2.getQty() - g.getQty());
				inventoryRepository.save(i);
				goodoutRepository.save(g);		
				return new ResponseEntity<Goodout>(g,HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}				
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			
	}
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/insertLogs")
	public @ResponseBody ResponseEntity<List<Goodout>> showLogs(){
		if(goodoutRepository.count() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}else {
			return new ResponseEntity<List<Goodout>>(goodoutRepository.findAll(),HttpStatus.OK);
		}
	}
}
