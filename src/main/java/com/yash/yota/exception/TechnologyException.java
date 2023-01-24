package com.yash.yota.exception;

/**This is a custom exception class for POST,PUT request
 * @author pratik.kurbet
 *
 */
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
