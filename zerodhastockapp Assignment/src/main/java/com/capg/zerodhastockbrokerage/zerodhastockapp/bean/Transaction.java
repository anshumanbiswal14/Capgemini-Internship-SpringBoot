package com.capg.zerodhastockbrokerage.zerodhastockapp.bean;

import javax.persistence.CascadeType;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Entity
@ApiModel(value = "Transaction Bean")
@Table(name = "Transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transId;
	
	@ApiModelProperty(name = "Stock quantity", value = "This holds the quantity of stocks during the transaction process")
	private int quantity;
	
	@ApiModelProperty(name = "Transaction type", value = "This holds the type of transaction that happened for a perticular stock BUY or SELL",required = true)
	private String transactionType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "StockInfo", referencedColumnName = "stockId")
	private Stock st;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transId, int quantity, String transactionType, Stock st) {
		super();
		this.transId = transId;
		this.quantity = quantity;
		this.transactionType = transactionType;
		this.st = st;
	}
	public Transaction(int quantity, String transactionType, Stock st) {
		super();
		
		this.quantity = quantity;
		this.transactionType = transactionType;
		this.st = st;
	}
	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Stock getSt() {
		return st;
	}

	public void setSt(Stock st) {
		this.st = st;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
		result = prime * result + ((st == null) ? 0 : st.hashCode());
		result = prime * result + transId;
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
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
		Transaction other = (Transaction) obj;
		if (quantity != other.quantity)
			return false;
		if (st == null) {
			if (other.st != null)
				return false;
		} else if (!st.equals(other.st))
			return false;
		if (transId != other.transId)
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", quantity=" + quantity + ", transactionType=" + transactionType
				+ ", st=" + st + "]";
	}
	
}// end of class