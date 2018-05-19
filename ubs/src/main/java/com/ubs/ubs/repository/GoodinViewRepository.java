package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.GoodinView;

@Repository
public interface GoodinViewRepository extends JpaRepository<GoodinView,Integer>{
	
}
