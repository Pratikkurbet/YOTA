package com.yash.yota.exception;

public class TechnologyNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TechnologyNotFoundException() {
		super();
	}
	
	public TechnologyNotFoundException(String errorMsg) {
		super(errorMsg);
	}
	
	
}
