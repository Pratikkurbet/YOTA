package com.yash.yota.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 
 * @author pankaj.ssharma
*/
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class ParentTechnologyExceptionResponse {
	/**
	 * This errorMessage field is used to customize the exception response.
	 */
	private String errorMessage;
}
