package com.cpag.msc.myshoppingcart.exception;

public class InvalidRatingException extends Exception {

	private int rating;

	public InvalidRatingException() {
		super();
		
	}

	
	public InvalidRatingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	
	public InvalidRatingException(String message, Throwable cause) {
		super(message, cause);
		
	}

	
	public InvalidRatingException(String message) {
		super(message);
		
	}

	public InvalidRatingException(Throwable cause) {
		super(cause);
		
	}

	public InvalidRatingException(int rating) {
		super();
		this.rating = rating;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	
}
