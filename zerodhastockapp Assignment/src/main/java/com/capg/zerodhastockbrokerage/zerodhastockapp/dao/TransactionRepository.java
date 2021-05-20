package com.capg.zerodhastockbrokerage.zerodhastockapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.zerodhastockbrokerage.zerodhastockapp.bean.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}