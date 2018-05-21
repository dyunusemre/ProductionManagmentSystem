package com.ubs.ubs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.ubs.model.Inventory;
import com.ubs.ubs.model.InventoryView;
import com.ubs.ubs.model.Product;
import com.ubs.ubs.model.Warehouse;
import com.ubs.ubs.repository.InventoryViewRepository;
import com.ubs.ubs.repository.WarehouseRepository;



@RestController
@RequestMapping(value = "/warehouse")
public class WarehouseController {
	@Autowired 
	WarehouseRepository warehouseRepository;
	@Autowired
	InventoryViewRepository inventoryViewRepository;
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value="/findWarehouse",
			params = {"id"})
	public @ResponseBody Warehouse getWarehouseById(@RequestParam("id") int id){
		return warehouseRepository.findById(id);
	}
	
	@CrossOrigin(allowCredentials="true")
	@PostMapping(value="/insertWarehouse")
	public @ResponseBody ResponseEntity<Warehouse> insertWarehouse(@RequestBody Warehouse w){
		warehouseRepository.save(w);
		return new ResponseEntity<Warehouse>(w,HttpStatus.OK);
	}
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value="/getAllWarehouses",
				produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Warehouse> getAllWarehouses(){
		return warehouseRepository.findAll();
	}
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value="/inventory",
				produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<InventoryView> getStockCard(){
		return inventoryViewRepository.findAll();
	}
	


}
