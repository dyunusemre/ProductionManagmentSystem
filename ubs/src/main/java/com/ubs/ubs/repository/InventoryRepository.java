package com.ubs.ubs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Inventory;
import com.ubs.ubs.model.InventoryId;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,InventoryId>{

}
