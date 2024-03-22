package com.atd.student.curd.operation.centralized.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {
		
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ExceptionModel> nullPointerException(NullPointerException exception)
	{
		ExceptionModel model=new ExceptionModel();
		model.setExcId("npe");
		model.setMsg(exception.getMessage());
		model.setLocation(exception.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(model);
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<ExceptionModel> handleIllegalArg(IllegalArgumentException exception)
	{
		ExceptionModel model=new ExceptionModel();
		model.setExcId(HttpStatus.NOT_ACCEPTABLE.toString());
		model.setMsg(exception.getMessage());
		model.setLocation(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(model);
		
	}
}
