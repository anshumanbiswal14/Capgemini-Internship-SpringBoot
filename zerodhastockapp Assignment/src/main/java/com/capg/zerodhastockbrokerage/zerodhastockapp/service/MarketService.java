package com.capg.zerodhastockbrokerage.zerodhastockapp.service;

import java.util.List;

import com.capg.zerodhastockbrokerage.zerodhastockapp.bean.Stock;
import com.capg.zerodhastockbrokerage.zerodhastockapp.bean.Transaction;

public interface MarketService {
	
	public List<Stock> getAllStock();
	
	public Stock saveStock(Stock s);
	
	public List<Transaction> getAllTransaction();
	
	public Transaction saveTransaction(Transaction t);
	
	public Stock updatedStock(String stockName, int quantity, String type);
	
	public Stock getStockById(int id);
	
	public Transaction getTransactionById(int id);
	

}