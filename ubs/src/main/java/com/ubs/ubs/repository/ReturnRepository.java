package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubs.ubs.model.Return;

public interface ReturnRepository extends JpaRepository<Return,Integer>{
	Return findById(int i);
}
