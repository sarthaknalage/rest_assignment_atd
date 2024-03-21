package com.atd.student.curd.operation.customExceptions;

public class StudentNotPresent extends Exception {
	public StudentNotPresent() {
		super("Requested Object is not present");
	}
	public StudentNotPresent(String customMsg) {
		super(customMsg);
	}

}
