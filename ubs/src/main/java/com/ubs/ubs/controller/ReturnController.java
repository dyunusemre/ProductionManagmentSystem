package com.ubs.ubs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.ubs.model.Goodin;
import com.ubs.ubs.model.Goodout;
import com.ubs.ubs.model.Inventory;
import com.ubs.ubs.model.InventoryId;
import com.ubs.ubs.model.Product;
import com.ubs.ubs.model.Return;
import com.ubs.ubs.model.Transfer;
import com.ubs.ubs.model.Warehouse;
import com.ubs.ubs.repository.GoodinRepository;
import com.ubs.ubs.repository.GoodoutRepository;
import com.ubs.ubs.repository.InventoryRepository;
import com.ubs.ubs.repository.ProductRepository;
import com.ubs.ubs.repository.ReturnRepository;
import com.ubs.ubs.repository.TransferRepository;
import com.ubs.ubs.repository.WarehouseRepository;

@RestController
@RequestMapping(value="/return")
public class ReturnController {
	@Autowired
	GoodinRepository goodinRepository;
	@Autowired
	GoodoutRepository goodoutRepository;
	@Autowired
	TransferRepository transferRepository;
	@Autowired
	InventoryRepository inventoryRepository;
	@Autowired
	WarehouseRepository warehouseRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ReturnRepository returnRepository;
	
	@CrossOrigin(allowCredentials="true")
	@PostMapping(value="/sell_return")
	public @ResponseBody ResponseEntity<Return> sellReturn(@RequestBody Return r){
		// return edildi mi kontrol et. daha once edilmis ise direkt return etme return error don.
		r.setTransactionType("sell");
		Goodout g_out = goodoutRepository.getOne(r.getTransactionId());
		int w_id = g_out.getW_id();
		int p_id = g_out.getP_id();
		int qty = g_out.getQty();
		Warehouse warehouse = warehouseRepository.getOne(w_id);
		Product product = productRepository.getOne(p_id);
		Inventory inventory = inventoryRepository.getOne(new InventoryId(product, warehouse));
		inventory.increaseQty(qty);
		Goodin g_in = new Goodin("sell_return", qty, p_id, w_id);
		inventoryRepository.save(inventory);
		goodinRepository.save(g_in);
		returnRepository.save(r);
		return new ResponseEntity<Return>(r,HttpStatus.OK);	
	}
	
	@CrossOrigin(allowCredentials="true")
	@PostMapping(value="/buy_return")
	public @ResponseBody ResponseEntity<Return> buyReturn(@RequestBody Return r){
		// return edildi mi kontrol et. daha once edilmis ise direkt return etme return error don.
		r.setTransactionType("buy");
		Goodin g_in = goodinRepository.getOne(r.getTransactionId());
		int w_id = g_in.getW_id();
		int p_id = g_in.getP_id();
		int qty = g_in.getQty();
		Warehouse warehouse = warehouseRepository.getOne(w_id);
		Product product = productRepository.getOne(p_id);
		Inventory inventory = inventoryRepository.getOne(new InventoryId(product, warehouse));
		if(! inventory.decreaseQty(qty)) {
			return new ResponseEntity<> (HttpStatus.PRECONDITION_FAILED);		// http status: 412
		}
		Goodout g_out = new Goodout("buy_return", qty, p_id, w_id);
		inventoryRepository.save(inventory);
		goodoutRepository.save(g_out);
		returnRepository.save(r);
		return new ResponseEntity<Return>(r,HttpStatus.OK);	
	}
	
	@CrossOrigin(allowCredentials="true")
	@PostMapping(value="/transfer_return")
	public ResponseEntity<Return> transfer_return(@RequestBody Return r){
		// return edildi mi kontrol et. daha once edilmis ise direkt return etme return error don.
		r.setTransactionType("transfer");
		Transfer t = transferRepository.getOne(r.getTransactionId());
		int in_w_id = t.getInWarehouseId();
		int out_w_id = t.getOutWarehouseId();
		int p_id = t.getProductId();
		int qty = t.getQty();
		Warehouse in_warehouse = warehouseRepository.getOne(in_w_id);
		Warehouse out_warehouse = warehouseRepository.getOne(out_w_id);
		Product product = productRepository.getOne(p_id);
		Inventory in_inventory = inventoryRepository.getOne(new InventoryId(product, in_warehouse));
		Inventory out_inventory = inventoryRepository.getOne(new InventoryId(product, out_warehouse));
		if(! in_inventory.decreaseQty(qty)) {
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		}
		out_inventory.increaseQty(qty);
		Transfer return_t = new Transfer(out_w_id, in_w_id, p_id, qty, "return_transfer");
		transferRepository.save(return_t);
		inventoryRepository.save(in_inventory);
		inventoryRepository.save(out_inventory);
		returnRepository.save(r);
		return new ResponseEntity<Return>(r, HttpStatus.OK);
	}
}
