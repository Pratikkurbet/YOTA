package com.yash.yota.exception;

public class ParentTechnologyNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ParentTechnologyNotFoundException() {
		super();
	}
	
	public ParentTechnologyNotFoundException(String errorMsg) {
		super(errorMsg);
	}
	
	
}
