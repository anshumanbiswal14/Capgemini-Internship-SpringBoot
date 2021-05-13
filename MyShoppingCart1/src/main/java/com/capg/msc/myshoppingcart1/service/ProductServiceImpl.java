package com.capg.msc.myshoppingcart1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.msc.myshoppingcart1.bean.Product;
import com.capg.msc.myshoppingcart1.dao.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repo;

	@Override
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}
	
	
	
	@Override
	@Transactional
	public Product saveProduct(Product p) {
		
		repo.save(p);
		return null;
		
		
	}
	
	public void delete(int productId) {
		repo.deleteById(productId);
	}


}