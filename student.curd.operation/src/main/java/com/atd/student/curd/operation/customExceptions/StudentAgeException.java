package com.atd.student.curd.operation.customExceptions;

public class StudentAgeException extends Exception{
	
	public StudentAgeException() {
		super("Inserted Age is not fullfilled Requirement please insert correct age !!");
	}
	
	public StudentAgeException(String customMsg) {
		super(customMsg);
	}
}
