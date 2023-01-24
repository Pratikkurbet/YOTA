package com.yash.yota.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**	This class is for handle our validation errors
 * @author pratik.kurbet
 *
 */
@Service
public class TechnologyValidationService {
	
	/**
	 * @param result
	 * @return It returns the field name with its validation error
	 */
	public ResponseEntity<?> validationError(BindingResult result)
	{
		if (result.hasErrors()) {
			Map<String, String> errorMsg=new HashMap<>();
			for (FieldError error:result.getFieldErrors()) {
				errorMsg.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMsg,HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
