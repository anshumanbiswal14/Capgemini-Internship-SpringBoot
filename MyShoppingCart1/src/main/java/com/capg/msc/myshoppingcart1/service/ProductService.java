package com.capg.msc.myshoppingcart1.service;

import java.util.List;

import com.capg.msc.myshoppingcart1.bean.Product;

public interface ProductService {

	
	public List<Product> getAllProducts();
	
	public Product saveProduct(Product p);

	public void delete(int productId);

	
}