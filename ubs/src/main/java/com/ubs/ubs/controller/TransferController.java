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


import com.ubs.ubs.model.Inventory;
import com.ubs.ubs.model.InventoryId;
import com.ubs.ubs.model.Product;
import com.ubs.ubs.model.RecentTransaction;
import com.ubs.ubs.model.ReturnTransferView;
import com.ubs.ubs.model.Transfer;
import com.ubs.ubs.model.TransferView;
import com.ubs.ubs.model.Warehouse;
import com.ubs.ubs.repository.GoodinRepository;
import com.ubs.ubs.repository.GoodoutRepository;
import com.ubs.ubs.repository.InventoryRepository;
import com.ubs.ubs.repository.ProductRepository;
import com.ubs.ubs.repository.RecentTransactionsRepository;
import com.ubs.ubs.repository.ReturnTransferViewRepository;
import com.ubs.ubs.repository.TransferRepository;
import com.ubs.ubs.repository.TransferViewRepository;
import com.ubs.ubs.repository.WarehouseRepository;

@RestController
@RequestMapping(value = "/transfer")
public class TransferController {
	@Autowired
	WarehouseRepository warehouseRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	InventoryRepository inventoryRepository;
	@Autowired
	GoodinRepository goodInRepository;
	@Autowired
	GoodoutRepository goodOutRepository;
	@Autowired
	TransferRepository transferRepository;
	@Autowired
	TransferViewRepository transferViewRepository;
	@Autowired
	RecentTransactionsRepository recentRepository;
	@Autowired
	ReturnTransferViewRepository returnTransferViewRepository;
	
	@CrossOrigin(allowCredentials="true")
	@PostMapping(value="/transferGoods")
	public @ResponseBody ResponseEntity<Transfer> transferGoods(@RequestBody Transfer t){
		t.setType("transfer");
		Warehouse in_warehouse = warehouseRepository.getOne(t.getInWarehouseId());
		Warehouse out_warehouse = warehouseRepository.getOne(t.getOutWarehouseId());
		Product out_product = productRepository.getOne(t.getProductId());
		Inventory out_inventory = inventoryRepository.getOne(new InventoryId(out_product, out_warehouse));
		Inventory in_inventory;
		if(inventoryRepository.existsById(new InventoryId(out_product, in_warehouse)))
			in_inventory = inventoryRepository.getOne(new InventoryId(out_product, in_warehouse));			
		else
			in_inventory = new Inventory(new InventoryId(out_product, in_warehouse),0);
		if(! out_inventory.decreaseQty(t.getQty()))
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);		// http status 412
		in_inventory.increaseQty(t.getQty());
		inventoryRepository.save(in_inventory);
		inventoryRepository.save(out_inventory);
		transferRepository.save(t);
		RecentTransaction rt = new RecentTransaction(t.getType(), t.getId());
		recentRepository.save(rt);
		return new ResponseEntity<Transfer>(t,HttpStatus.OK);
	}
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value="/getAllTransfers")
	public @ResponseBody List<TransferView> getAllTransfers(){
		return transferViewRepository.findAll();
	}
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value="/getAllReturnTransfers")
	public @ResponseBody List<ReturnTransferView> getAllReturnTransfers() {
		return returnTransferViewRepository.findAll();
	}
	
	
	
}
