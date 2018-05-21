package com.ubs.ubs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Product;
import com.ubs.ubs.model.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Integer>{
	Warehouse findById(int i);
	

}
