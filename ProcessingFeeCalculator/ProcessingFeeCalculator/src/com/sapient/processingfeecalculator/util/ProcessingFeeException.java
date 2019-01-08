package com.sapient.processingfeecalculator.util;

public class ProcessingFeeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1133032311216221030L;
	private String msg;
	public ProcessingFeeException(){
		this.msg = "There is some exception. Please try again later";
	}
	
	public ProcessingFeeException(String msg){
		this.msg = msg;
	}
	
	@Override
	public String toString(){
		
		return msg;
	}
	
	@Override
	public String getMessage(){
		return msg;
	}
}
