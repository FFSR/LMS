package com.web.lms.wrapper;

import java.util.List;

import com.web.lms.model.LmsLeaveBalance;

public class ResponseWrapper {
	String message;
	
	LmsLeaveBalance lmsLeaveBalance;
	
	List<LmsLeaveBalance> listLmsLeaveBalance;

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

	public List<LmsLeaveBalance> getListLmsLeaveBalance() {
		return listLmsLeaveBalance;
	}

	public void setListLmsLeaveBalance(List<LmsLeaveBalance> listLmsLeaveBalance) {
		this.listLmsLeaveBalance = listLmsLeaveBalance;
	}
	
}
