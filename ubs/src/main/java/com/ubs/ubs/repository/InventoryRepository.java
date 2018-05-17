package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer>{

}
