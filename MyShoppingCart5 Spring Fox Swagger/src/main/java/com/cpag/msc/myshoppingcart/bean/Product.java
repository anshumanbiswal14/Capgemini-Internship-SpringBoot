package com.cpag.msc.myshoppingcart.bean;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value="Product Bean")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(name="Product ID", value="Holds the minimum 3 INT Value", required=true)
	private int productId;
	
	@NotEmpty(message="Sorry! Product : NAME cannot be empty")
	@ApiModelProperty(name="Product NAME", value="Holds the minimum 3 CHAR Value", required=true)
	private String productName;
	
	@Min(value=1000,message="Sorry! Product : COST cannot be less than 1000")
	@ApiModelProperty(name="Product COST", value="Holds the Cost of the Laptop with minimum cost of Rs:1000")
	private int productCost;
	
	@Max(value=5,message="Sorry! We recommend star rating out of 5 ")
	@ApiModelProperty(name="Product ID", value="Holds the star rating out of 5", required=true)
	private int starRating;
	
	
	@Pattern(regexp="^Laptop",message="Not Matching our Laptop Inventory!")
	@ApiModelProperty(name="Product ID", value="Holds the Laptop Category only", required=true)
	private String category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + productCost;
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + starRating;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (productCost != other.productCost)
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (starRating != other.starRating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", starRating=" + starRating + ", category=" + category + "]";
	}

}