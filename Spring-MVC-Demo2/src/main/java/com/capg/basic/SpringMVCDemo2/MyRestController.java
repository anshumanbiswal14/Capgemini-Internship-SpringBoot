package com.capg.basic.SpringMVCDemo2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyRestController {
	
	
	public MyRestController() {
		super();
		
		System.out.println("inside this controller");
	}

	@Autowired
	ProductDAOImpl dao;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello";
	}
    
	//  localhost:9090:\product\10000\40000
	//  endpoint :- www.abc.com\product\10000\40000
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
	
}
