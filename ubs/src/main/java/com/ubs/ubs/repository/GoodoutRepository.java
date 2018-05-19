package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Goodout;
@Repository
public interface GoodoutRepository extends JpaRepository<Goodout,Integer> {

}
