package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.GoodoutView;
@Repository
public interface GoodoutViewRepository extends JpaRepository<GoodoutView,Integer>{
	
}
