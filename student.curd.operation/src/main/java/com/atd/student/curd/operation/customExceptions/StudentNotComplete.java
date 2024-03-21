package com.atd.student.curd.operation.customExceptions;

public class StudentNotComplete extends Exception {
	
	public StudentNotComplete() {
		super("Inserted Student is not contains required field !!! So please filled all the details and do try");
	}
	
	public StudentNotComplete(String customException) {
		super(customException);
	}
}
