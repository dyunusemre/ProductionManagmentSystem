package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.ReturnGiView;
import com.ubs.ubs.model.ReturnGoView;
import com.ubs.ubs.model.ReturnTransferView;

@Repository
public interface ReturnTransferViewRepository extends JpaRepository<ReturnTransferView,Integer> {
	
}
