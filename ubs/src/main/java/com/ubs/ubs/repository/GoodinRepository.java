package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Goodin;

@Repository
public interface GoodinRepository extends JpaRepository<Goodin,Long>{
	Goodin findById(int i);

}
