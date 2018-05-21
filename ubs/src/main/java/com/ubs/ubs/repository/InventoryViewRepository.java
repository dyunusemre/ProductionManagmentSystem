package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubs.ubs.model.InventoryView;
import com.ubs.ubs.model.idview;

public interface InventoryViewRepository extends JpaRepository<InventoryView,idview>{

}
