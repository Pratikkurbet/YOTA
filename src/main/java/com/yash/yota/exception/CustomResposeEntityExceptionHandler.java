package com.yash.yota.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResposeEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler
	public final ResponseEntity<?> handleTechnologyException(TechnologyException technologyException,WebRequest request)
	{
		TechnologyExceptionResponse response= new TechnologyExceptionResponse(technologyException.getMessage());
		return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	}
}
