package com.yash.yota.exception;

public class TechnologyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TechnologyException() {
		super();
	}
	
	public TechnologyException(String errorMsg) {
		super(errorMsg);
	}
}
