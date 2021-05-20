package com.capg.zerodhastockbrokerage.web;
import java.time.LocalDateTime;



import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.zerodhastockbrokerage.bean.Stock;
import com.capg.zerodhastockbrokerage.bean.Transaction;
import com.capg.zerodhastockbrokerage.service.MarketService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api")
@ApiModel(value = "Zerodha Stock App", description = "Holds all Stocks for Buy and Sell listed on NSE/BSE")
public class MarketRestController {
	
	

	public MarketRestController() {
		
		System.out.println(" ----->> Inside Constructor (OK!)");
		
	}

	@Autowired
	private MarketService service;
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome to Zerodha Stock Brokerage"+LocalDateTime.now();
	}
	
	@ApiOperation(value = "Stock POST mapping to add new stocks", response = Stock.class)
	@PostMapping("/stock")
	public Stock insertStock(@RequestBody @Valid Stock stock) {
		service.saveStock(stock);
		return stock;
	}
	
	@ApiOperation(value = "Stock GET mapping to fetch all stocks available in the List", response = List.class)
	@GetMapping("/stocks")
	public List<Stock> getAllStocks() {
		return service.getAllStock();
	}
	
	
	@ApiOperation(value = "Transaction POST mapping to add new transaction details", response = Transaction.class)
	@PostMapping("/transaction")
	public Transaction insertTransaction(@RequestBody Transaction t) {
		service.saveTransaction(t);
		return t;
	}
	
	@ApiOperation(value = "Transaction GET mapping to fetch all transactions available in the List", response = List.class)
	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return service.getAllTransaction();
	}
	
	
	@ApiOperation(value = "Transaction GET mapping to make a transaction buy or sell", response = Stock.class)
	@GetMapping("/stock/{stockName}/{quantity}/{type}")
	public Stock updatedStock(@PathVariable String stockName, @PathVariable int quantity, @PathVariable String type) {
		
		return service.updatedStock(stockName, quantity, type);
		
	}
	
	
	@ApiOperation(value = "Transaction GET mapping to fetch transaction using transaction ID", response = Transaction.class)
	@GetMapping("/transaction/{transactionId}")
	public Transaction getTransactionById(@PathVariable int transactionId) {
		return service.getTransactionById(transactionId);
	}
	
	@ApiOperation(value = "Stock GET mapping to fetch stock using stock ID", response = Stock.class)
	@GetMapping("/stock/{id}")
	public Stock getStockById(@PathVariable int id) {
		return service.getStockById(id);
	}
		
}