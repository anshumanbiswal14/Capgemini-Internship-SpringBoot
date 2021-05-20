package com.capg.zerodhastockbrokerage.service;

import java.util.List;


import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.zerodhastockbrokerage.bean.Stock;
import com.capg.zerodhastockbrokerage.bean.Transaction;
import com.capg.zerodhastockbrokerage.dao.StockRepository;
import com.capg.zerodhastockbrokerage.dao.TransactionRepository;


@Service
public class MarketServiceImpl implements MarketService{
	
	@Autowired
	StockRepository stockrepo;
	
	@Autowired
	TransactionRepository transactionRepo;

	@Override
	public List<Stock> getAllStock() {
		// TODO Auto-generated method stub
		return stockrepo.findAll();
	}

	@Override
	public Stock saveStock(Stock s) {
		// TODO Auto-generated method stub
		stockrepo.save(s);
		return s;
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return transactionRepo.findAll();
	}

	@Override
	public Transaction saveTransaction(Transaction t) {
		// TODO Auto-generated method stub
		transactionRepo.save(t);
		return t;
	}

	@Override
	public Stock updatedStock(String stockName, int quantity, String type) {
		// TODO Auto-generated method stub
		List<Stock> sList = getAllStock();
		int x = 0;
		Stock s = null;
		for(Stock st : sList) {
			if(type.equals("buy")) {
			if(st.getStockName().equals(stockName)) {
				while(quantity >= 100) {
					int y = st.getStockPrice();
					x = (2*y)/100;
					int updatedPrice = y+x;
					System.out.println(updatedPrice);
					st.setStockPrice(updatedPrice);
					s = st;
					quantity -=100;
					stockrepo.save(s);
					
					
				}
			}
			}
			else if(type.equals("sell")) {
				if(st.getStockName().equals(stockName)) {
					while(quantity >= 100) {
				int y = st.getStockPrice();
				x = (2*y)/100;
				int updatedPrice = y-x;
				System.out.println(updatedPrice);
				st.setStockPrice(updatedPrice);
				s = st;
				quantity -=100;
				stockrepo.save(s);
					}
				}
			}
			
		}
		Transaction t = new Transaction(quantity, type, s);
		
		transactionRepo.save(t);
		return s;
	}

	@Override
	public Stock getStockById(int id)  {
		return stockrepo.findById(id).get();
		
	}
	
	@Override
	public Transaction getTransactionById(int id)  {
		return transactionRepo.findById(id).get();
		
	}
	

}