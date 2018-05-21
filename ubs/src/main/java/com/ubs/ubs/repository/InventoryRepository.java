package com.ubs.ubs.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Inventory;
import com.ubs.ubs.model.InventoryId;
import com.ubs.ubs.model.Product;
import com.ubs.ubs.model.Warehouse;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,InventoryId>{
	List<Product> findByPrimaryKeyProductId(int id); 
}
