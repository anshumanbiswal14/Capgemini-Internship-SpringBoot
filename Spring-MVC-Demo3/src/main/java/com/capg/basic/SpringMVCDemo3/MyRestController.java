package com.capg.basic.SpringMVCDemo3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyRestController {
	
	
	public MyRestController() {
		super();
		
		System.out.println("inside this controller.... it's Working");
	}

	@Autowired
	ProductDAOImpl dao;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello User!";
	}
    
	//localhost:8089:\product\10000\40000
	//endpoint :- www.abc.com\product\10000\40000
	@GetMapping("/product/{r1}/{r2}")
	public List<Product> getProductsbyrange(@PathVariable int r1 ,@PathVariable int r2)
	{
		return dao.getProductsByRange(r1, r2);
	}	
	
	// ..../product/101
	@GetMapping("/product/{searchid}")
	public Product getProductByid(@PathVariable int searchid)
	{
		return dao.getProductById(searchid);
	}
	
	//..../product/Yes or No
	@GetMapping("/avail/product/{searchaval}")
	public Product getProductbyAvailability(@PathVariable String searchaval)
	{
		return dao.getProductbyAvailability(searchaval);
	}
	
	//...../product/5
	@GetMapping("/rating/product/{searchstar}")
	public Product getProductbyStarRating(@PathVariable int searchstar)
	{
		return dao.getProductbyStarRating(searchstar);
	}
	
	@GetMapping("/delete/product/{deleteproduct}")
	public List<Product> doDeleteById(@PathVariable int delId) 
	{
		
		return dao.getAllProducts();
	}
}

