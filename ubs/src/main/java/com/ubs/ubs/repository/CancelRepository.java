package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.Cancel;

@Repository
public interface CancelRepository extends JpaRepository<Cancel,Long> {

}
