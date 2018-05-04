package com.web.lms.wrapper;

import com.web.lms.model.LmsLeaveBalance;

public class ResponseWrapperLeaveRule {
	
	String message;
	LmsLeaveBalance lmsLeaveBalance;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public LmsLeaveBalance getLmsLeaveBalance() {
		return lmsLeaveBalance;
	}

	public void setLmsLeaveBalance(LmsLeaveBalance lmsLeaveBalance) {
		this.lmsLeaveBalance = lmsLeaveBalance;
	}
}




