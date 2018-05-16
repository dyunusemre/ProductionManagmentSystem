package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Cancel;
import com.ubs.ubs.model.Goodout;

@Repository
public interface CancelRepository extends CrudRepository<Cancel,Long> {
	Cancel findById(int i);

}
