package com.capg.zerodhastockbrokerage.dao;

import org.springframework.data.jpa.repository.JpaRepository;



import com.capg.zerodhastockbrokerage.bean.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{
	

}