package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ubs.ubs.model.Goodout;

public interface GoodoutRepository extends JpaRepository<Goodout,Long> {

}
