package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer,Integer>{
	Transfer findById(int i);

}
