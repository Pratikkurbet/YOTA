package com.yash.yota.exception;

/** This is a custom exception class for GET request
 * @author pratik.kurbet
 *
 */
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
