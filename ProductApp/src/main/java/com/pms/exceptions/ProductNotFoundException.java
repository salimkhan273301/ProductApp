package com.pms.exceptions;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {
	ProductNotFoundException(String msg) {
		super(msg);
		
	}
	
	public String toString() {
		return "no Such id is persent please Enter right id:";
		
	}
	public  String getMassage() {
		return "not valid ID";
		
	}

}
