package com.capg.zerodhastockbrokerage.zerodhastockapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.zerodhastockbrokerage.zerodhastockapp.bean.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{
	

}