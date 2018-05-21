package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.ReturnGoView;

@Repository
public interface ReturnGoViewRepository extends JpaRepository<ReturnGoView,Integer> {
	
}
