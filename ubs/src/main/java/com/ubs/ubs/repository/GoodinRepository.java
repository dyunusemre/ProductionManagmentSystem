package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Goodin;

@Repository
public interface GoodinRepository extends JpaRepository<Goodin,Integer>{
	Goodin findById(int i);

}
