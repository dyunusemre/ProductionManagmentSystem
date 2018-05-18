package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Transfer;
import com.ubs.ubs.model.Warehouse;

@Repository
public interface TransferRepository extends JpaRepository<Transfer,Integer>{
	Transfer findById(int i);

}
