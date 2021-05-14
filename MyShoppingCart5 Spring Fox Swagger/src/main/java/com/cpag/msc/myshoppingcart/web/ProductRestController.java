package com.cpag.msc.myshoppingcart.web;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cpag.msc.myshoppingcart.bean.Product;
import com.cpag.msc.myshoppingcart.exception.InvalidCostRangeException;
import com.cpag.msc.myshoppingcart.exception.InvalidRatingException;
import com.cpag.msc.myshoppingcart.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Validated
@RestController
@RequestMapping("/api")
@Api(value="My Laptop Inventory", description="Various API Works on Laptop Inventory Management")
public class ProductRestController {

	@Autowired
	private ProductService service;
	
	
	public ProductRestController() {
		System.out.println(" ----->> Product Rest Controller Constructor ");
	}

	@GetMapping("/home")
	public String homeRequest()
	{
		return "Welcome : My Shopping App "+LocalDateTime.now();
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id)
	{
		return service.getProductById(id);
		
	}
	
	@ApiOperation(value="product POST Mapping", response=Product.class)
	@PostMapping("/product")
	public Product insertProduct(@Valid @RequestBody Product product)
	{
		service.saveProduct(product);
		return product;
		
	}
	@ApiOperation(value="product GET Mapping", response=List.class)
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return service.getAllProducts();
	}
	
	@GetMapping("/products/{category}")
	public List<Product> getAllProductsByCategory(@PathVariable String category)
	{
		return service.getAllProductsByCategory(category);
	}
	
	@GetMapping("/products/{category}/{range1}/{range2}")
	public List<Product> getAllProductsByCategoryAndPrice(@PathVariable String category,
			@PathVariable int range1,@PathVariable int range2)throws InvalidCostRangeException
	{
		if(category.equals("Laptop")&&range1<10000)
		{
			throw new InvalidCostRangeException(range1,range2);
		}
		return service.getAllProductsByCategoryAndPrice(category, range1, range2);
	}
	
	@GetMapping("/rating/{category}/{rating}")
	public List<Product> getProductbyStarRating(@PathVariable String category,@PathVariable int rating) throws InvalidRatingException
	{
		if(category.equals("Laptop")&&rating>5) {
			
			throw new InvalidRatingException(rating);
			
		}
		return service.getProductbyStarRating(rating);
	}
	
		
}//end class





