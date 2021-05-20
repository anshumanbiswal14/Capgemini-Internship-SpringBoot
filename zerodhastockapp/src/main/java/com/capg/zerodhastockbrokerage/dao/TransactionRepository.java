package com.capg.zerodhastockbrokerage.dao;

import org.springframework.data.jpa.repository.JpaRepository;



import com.capg.zerodhastockbrokerage.bean.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}