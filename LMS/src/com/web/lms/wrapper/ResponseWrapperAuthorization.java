package com.web.lms.wrapper;

public class ResponseWrapperAuthorization {
	
	String Message;
	boolean result;
	
	
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
}
