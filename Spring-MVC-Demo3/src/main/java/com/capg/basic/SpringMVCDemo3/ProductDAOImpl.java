package com.capg.basic.SpringMVCDemo3;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

//Manage Database

@Component
public class ProductDAOImpl {

	List<Product> list = new ArrayList<>();

	public ProductDAOImpl() {
		
		Product p1 = new Product(101, "DELL INSPIRON",95000,4,"Yes");
		Product p2 = new Product(102, "HP OMEN",100000,5,"Yes");
		Product p3 = new Product(103, "MACBOOK",125000,2,"No");
		Product p4 = new Product(104, "LENOVO",20000,3,"Yes");
		Product p5 = new Product(105, "ACER",45000,3,"Yes");
		
		list = Arrays.asList(p1,p2,p3,p4,p5);
	
	}
	
	// this will return all the products in JSON
	public List<Product> getAllProducts()
	{
		return list;
	}
	
	// this will return products b/w the price range
	public List<Product> getProductsByRange(int r1,int r2)
	{
		
		Comparator<Product> comp = (p1,p2)->p1.getProductCost() - p2.getProductCost();
		
		List<Product> productList = list.stream().
		filter((product)->product.getProductCost()>=r1&&product.getProductCost()<=r2).
		collect(Collectors.toList());
		
		return productList;
	}
	
	// this will search product by ID
	public Product getProductById(int searchid)
	{
		boolean isIdFound = false;
		Product searchedProduct = null;
		for (Product product : list) {
			if(product.getProductId() == searchid)
			{
				isIdFound = true;
				searchedProduct = product;
				break;
			}
		}
		return searchedProduct;
	}
	
	// this will search products by availability
	public Product getProductbyAvailability(String searchaval){
		
		boolean isFound = false;
		Product searchedProduct = null;
		for(Product product : list) {
			if(product.getAvailable() == searchaval) {
				
				isFound = true;
				searchedProduct = product;
				break;
			}
		}
		
		return searchedProduct;	
	}
	
	// this will search products by star rating of product
	public Product getProductbyStarRating(int searchstar) {
		boolean isFound = false;
		Product searchedProduct = null;
		for(Product product : list) {
			if(product.getStarRating() == searchstar) {
				isFound = true;
				searchedProduct = product;
				break;
			}
		}
		
		return searchedProduct;	
	}
	
	public Product doDeleteById(int delId)
	{
		Product p = getProductById(delId);
		boolean x = false;
		if(p != null)
		{
			System.out.println(" ===> DAO List Size before delete "+list.size()+" and p "+p);
			x = list.remove(p);
			System.out.println(" ===> DAO List Size after delete "+list.size());
			System.out.println(" ===>> DAO Delete operation "+x);
		}
		
		if(x) return p;
		else return null;
	}
	
	

}
