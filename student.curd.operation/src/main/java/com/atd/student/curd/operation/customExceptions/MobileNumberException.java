package com.atd.student.curd.operation.customExceptions;

public class MobileNumberException extends Exception{
	
	public MobileNumberException() {
		super("Mobile Number you inserted is wrong may be digit count is invalid !! please check it and insert one more time");
	}
	
	public MobileNumberException(String customException)
	{
		super(customException);
	}

}
