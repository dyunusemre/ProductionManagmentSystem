package com.ubs.ubs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.ubs.model.Cancel;
import com.ubs.ubs.model.Goodin;
import com.ubs.ubs.model.Goodout;
import com.ubs.ubs.model.Inventory;
import com.ubs.ubs.model.InventoryId;
import com.ubs.ubs.model.Product;
import com.ubs.ubs.model.RecentTransaction;
import com.ubs.ubs.model.Transfer;
import com.ubs.ubs.model.Warehouse;
import com.ubs.ubs.repository.CancelRepository;
import com.ubs.ubs.repository.GoodinRepository;
import com.ubs.ubs.repository.GoodoutRepository;
import com.ubs.ubs.repository.InventoryRepository;
import com.ubs.ubs.repository.ProductRepository;
import com.ubs.ubs.repository.RecentTransactionsRepository;
import com.ubs.ubs.repository.TransferRepository;
import com.ubs.ubs.repository.WarehouseRepository;


@RestController
@RequestMapping(value="/cancel")
public class CancelController {
	@Autowired
	GoodinRepository goodinRepository;
	@Autowired
	GoodoutRepository goodoutRepository;
	@Autowired
	TransferRepository transferRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	WarehouseRepository warehouseRepository;
	@Autowired
	InventoryRepository inventoryRepository;
	@Autowired
	CancelRepository cancelRepository;
	@Autowired
	RecentTransactionsRepository recentRepository;
	
	@CrossOrigin(allowCredentials="true")
	@PostMapping(value="/cancelTransaction")
	public ResponseEntity<Cancel> cancelTransaction(@RequestBody RecentTransaction rt){
		String type = rt.getId();
		int t_id = rt.getT_id();
		if(type.equals("buy")) {
			Goodin g = goodinRepository.getOne(t_id);
			Product p = productRepository.getOne(g.getP_id());
			Warehouse w = warehouseRepository.getOne(g.getW_id());
			Inventory i1 = inventoryRepository.getOne(new InventoryId(p, w));
			if(i1.decreaseQty(g.getQty())) {
				Cancel c = new Cancel(g.getId(), type);
				cancelRepository.save(c);				
				recentRepository.deleteById(type);
				goodinRepository.deleteById(g.getId());
				return new ResponseEntity<Cancel>(c,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
		}
		else if(type.equals("sell")) {
			Goodout g = goodoutRepository.getOne(t_id);
			Product p = productRepository.getOne(g.getP_id());
			Warehouse w = warehouseRepository.getOne(g.getW_id());
			Inventory i1 = inventoryRepository.getOne(new InventoryId(p, w));
			i1.increaseQty(g.getQty());
			Cancel c = new Cancel(g.getId(), type);
			cancelRepository.save(c);
			recentRepository.deleteById(type);
			goodinRepository.deleteById(g.getId());
			return new ResponseEntity<Cancel>(c,HttpStatus.OK);
		}
		else if(type.equals("transfer")) {
			Transfer t = transferRepository.getOne(t_id);
			Warehouse in_warehouse = warehouseRepository.getOne(t.getInWarehouseId());
			Warehouse out_warehouse = warehouseRepository.getOne(t.getOutWarehouseId());
			Product out_product = productRepository.getOne(t.getProductId());
			Inventory in_inventory = inventoryRepository.getOne(new InventoryId(out_product, in_warehouse));
			Inventory out_inventory = inventoryRepository.getOne(new InventoryId(out_product, out_warehouse));
			if(in_inventory.decreaseQty(t.getQty())) {
				out_inventory.increaseQty(t.getQty());
				inventoryRepository.save(in_inventory);
				inventoryRepository.save(out_inventory);
				Cancel c = new Cancel(t.getId(), type);
				cancelRepository.save(c);
				recentRepository.deleteById(type);
				transferRepository.deleteById(t.getId());
				return new ResponseEntity<Cancel>(c,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		}
	}
	
}
