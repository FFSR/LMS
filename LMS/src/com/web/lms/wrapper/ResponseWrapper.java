package com.web.lms.wrapper;

import java.util.List;

import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsLeaveBalance;
import com.web.lms.model.LmsUser;

public class ResponseWrapper {
	String message;
	
	LmsLeaveBalance lmsLeaveBalance;
	
	List<LmsLeaveBalance> listLmsLeaveBalance;
	
	LmsUser lmsuser;
	
	List<LmsUser> listLmsuser;
	
	LmsLeaveApplication lmsLeaveApplication;
	
	List<LmsLeaveApplication> listLmsLeaveApplication;


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
	
	public LmsUser getLmsuser() {
		return lmsuser;
	}

	public void setLmsuser(LmsUser lmsuser) {
		this.lmsuser = lmsuser;
	}

	
	public List<LmsUser> getListLmsuser() {
		return listLmsuser;
	}

	public void setListLmsuser(List<LmsUser> listLmsuser) {
		this.listLmsuser = listLmsuser;
	}

	public void setListLmsLeaveApplication(List<LmsLeaveApplication> lmsLeaveApplication) {
		this.listLmsLeaveApplication = lmsLeaveApplication;
	}
	
	public List<LmsLeaveApplication> getListLmsLeaveApplication() {
		return listLmsLeaveApplication;
	}
	
}




