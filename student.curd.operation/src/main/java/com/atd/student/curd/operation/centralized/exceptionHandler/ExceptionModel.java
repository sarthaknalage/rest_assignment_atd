package com.atd.student.curd.operation.centralized.exceptionHandler;

public class ExceptionModel {
	
	private String excId;
	
	private String msg;
	
	private String location; 
	
	public ExceptionModel() {
		
	}

	public ExceptionModel(String excId, String msg, String location) {
		super();
		this.excId = excId;
		this.msg = msg;
		this.location = location;
	}

	public String getExcId() {
		return excId;
	}

	public void setExcId(String excId) {
		this.excId = excId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "ExceptionModel [excId=" + excId + ", msg=" + msg + ", location=" + location + "]";
	}
	
	
}
