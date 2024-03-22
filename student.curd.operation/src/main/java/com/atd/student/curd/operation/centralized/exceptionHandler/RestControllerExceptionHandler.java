package com.atd.student.curd.operation.centralized.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.atd.student.curd.operation.customExceptions.MobileNumberException;
import com.atd.student.curd.operation.customExceptions.StudentAgeException;
import com.atd.student.curd.operation.customExceptions.StudentNotComplete;
import com.atd.student.curd.operation.customExceptions.StudentNotPresent;

import jakarta.persistence.OptimisticLockException;

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
	
	@ExceptionHandler(value=StudentAgeException.class)
	public ResponseEntity<ExceptionModel> handelStudentAgeException(StudentAgeException exception)
	{
		ExceptionModel model=new ExceptionModel();
		model.setExcId("age-err-5-70");
		model.setMsg(exception.getLocalizedMessage());
		model.setLocation(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(model);
	}
	
	@ExceptionHandler(value = StudentNotComplete.class)
	public ResponseEntity<ExceptionModel> handleIncompleteStudent(StudentNotComplete exception){
		ExceptionModel model=new ExceptionModel();
		model.setExcId("stdIncomplete-err");
		System.out.println(exception.getLocalizedMessage());
		System.out.println(exception.getMessage());
		model.setMsg(exception.getLocalizedMessage());
		model.setLocation(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(model);
	}
	
	@ExceptionHandler(value = MobileNumberException.class)
	public ResponseEntity<ExceptionModel> handleMobileNumber(MobileNumberException exception){
		ExceptionModel model=new ExceptionModel();
		model.setExcId("mob-digitcount-err");
		model.setMsg(exception.getLocalizedMessage());
		model.setLocation(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(model);
	}
	
	@ExceptionHandler(value = OptimisticLockException.class)
	public ResponseEntity<ExceptionModel> handleMobileNumber(OptimisticLockException exception){
		ExceptionModel model=new ExceptionModel();
		model.setExcId(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		model.setMsg(exception.getLocalizedMessage());
		model.setLocation(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(model);
	}
	@ExceptionHandler(value = StudentNotPresent.class)
	public ResponseEntity<ExceptionModel> handleMobileNumber(StudentNotPresent exception){
		ExceptionModel model=new ExceptionModel();
		model.setExcId(HttpStatus.NOT_FOUND+" student with id not present");
		model.setMsg(exception.getLocalizedMessage());
		model.setLocation(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
	}
}
