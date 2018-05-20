package com.ubs.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubs.ubs.model.RecentTransaction;

@Repository
public interface RecentTransactionsRepository extends JpaRepository<RecentTransaction, String>{
}
