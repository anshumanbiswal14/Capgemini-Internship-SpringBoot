package com.cpag.msc.myshoppingcart.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.cpag.msc.myshoppingcart.bean.Product;
import com.cpag.msc.myshoppingcart.exception.InvalidCostRangeException;


public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product saveProduct(Product p);
	
	public List<Product> getAllProductsByCategory(String category);
	
	public List<Product> getAllProductsByCategoryAndPrice(String category,int range1,int range2);
	
	public Product getProductById(int id);

	public List<Product> getProductbyStarRating(int rating);

	
}