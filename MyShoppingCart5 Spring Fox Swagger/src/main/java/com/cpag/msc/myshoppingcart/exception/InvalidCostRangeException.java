package com.cpag.msc.myshoppingcart.exception;

public class InvalidCostRangeException extends Exception {
	
	private int range1;
	private int range2;
	
	public InvalidCostRangeException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InvalidCostRangeException(int range1, int range2) {
		super();
		this.range1 = range1;
		this.range2 = range2;
	}
	public int getRange1() {
		return range1;
	}
	public void setRange1(int range1) {
		this.range1 = range1;
	}
	public int getRange2() {
		return range2;
	}
	public void setRange2(int range2) {
		this.range2 = range2;
	}

	public InvalidCostRangeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidCostRangeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCostRangeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCostRangeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}//end class