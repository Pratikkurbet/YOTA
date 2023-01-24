package com.yash.yota.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** This is a custom response class to handle our exception 
 * 	and present in proper manner
 * @author pratik.kurbet
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TechnologyExceptionResponse {
	/**
	 * This errorMessage is used to show error response for exceptions.
	 */
	private String errorMessage;
}
