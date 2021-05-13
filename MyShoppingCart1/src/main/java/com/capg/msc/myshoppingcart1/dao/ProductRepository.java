package com.capg.msc.myshoppingcart1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.msc.myshoppingcart1.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	/*
	 * findAll
	 * save
	 * update
	 * read
	 * delete
	 * all added automatically
	 * */

}