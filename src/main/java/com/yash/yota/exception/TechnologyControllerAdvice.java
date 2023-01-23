package com.yash.yota.exception;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/*
 * This class will handle our exception globally.
 * TODO :  Implement the GlobalException Handling mechanism
 */
//@ControllerAdvice
public class TechnologyControllerAdvice {

	//TODO : This method handles validation error for our provided validation on field level.
	/*
	  @ExceptionHandler(MethodArgumentNotValidException.class) public
	  ResponseEntity<List<String>> handleMethodArgumentNotValid(
	  MethodArgumentNotValidException methodArgumentNotValid) { JSONArray jsonArray
	  = new JSONArray(methodArgumentNotValid.getFieldErrors()); List<String>
	  jsonDefaultMessageList = new ArrayList<>();
	  
	  for (int i = 0; i < jsonArray.length(); i++) {
	  
	  jsonDefaultMessageList.add(jsonArray.getJSONObject(i).getString(
	  "defaultMessage"));
	  
	  } return new ResponseEntity<>(jsonDefaultMessageList,
	  HttpStatus.NOT_ACCEPTABLE); } */
	 
}
