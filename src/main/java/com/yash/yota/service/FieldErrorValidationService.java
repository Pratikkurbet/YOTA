package com.yash.yota.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * This FieldErrorValidationService Component will help to map the Field Error in errorMap. 
 * This can be used with any model error mapping. 
 * @author pankaj.ssharma
 *
 */
@Service
public class FieldErrorValidationService {
	
	public ResponseEntity<?> validationError(BindingResult result)
	{
		if (result.hasErrors()) {
			Map<String, String> errorMap=new HashMap<>();
			for (FieldError error:result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
