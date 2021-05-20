package com.capg.zerodhastockbrokerage.zerodhastockapp.bean;

import javax.persistence.Entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@ApiModel(value = "Stock Bean")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId;
	
	@ApiModelProperty(name = "Stock Name", value = "It holds only alphabets and accepts minimum 3 Chars", required = true)
	@NotEmpty(message = "Stock NAME can't me empty!")
	@Size(min = 3, max = 20, message = "Invalid stock Name please enter a vaild STOCK NAME!")
	@Pattern(regexp="^[A-Za-z]+",message = "INVALID PLEASE ENTER AGAIN")
	private String stockName;
	
	@ApiModelProperty(name = "Stock Price", value = "It holds the Stock PRICE and this value can't be negative", required = true)
	@Positive(message = "Negative price NOT ALLOWED!")
	private int stockPrice;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Stock(int stockId, String stockName,int stockPrice) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
	}

	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stockId;
		result = prime * result + ((stockName == null) ? 0 : stockName.hashCode());
		result = prime * result + stockPrice;
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
		Stock other = (Stock) obj;
		if (stockId != other.stockId)
			return false;
		if (stockName == null) {
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		if (stockPrice != other.stockPrice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", stockPrice=" + stockPrice + "]";
	}
	
}// end of class