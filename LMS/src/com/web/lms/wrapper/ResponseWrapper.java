package com.web.lms.wrapper;

import java.util.List;

import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsLeaveBalance;
import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsHolidayRecord;


public class ResponseWrapper {
	String message;
	
	LmsLeaveBalance lmsLeaveBalance;
	
	List<LmsLeaveBalance> listLmsLeaveBalance;
	
	LmsUser lmsuser;
	
	List<LmsUser> listLmsuser;
	
	LmsLeaveApplication lmsLeaveApplication;
	
	List<LmsLeaveApplication> listLmsLeaveApplication;
	
	LmsHolidayRecord lmsHolidayRecord;
	
	List<LmsHolidayRecord> listLmsHolidayRecord;


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

	public List<LmsLeaveApplication> getListLmsLeaveApplication() {
		return listLmsLeaveApplication;
	}

	public void setListLmsLeaveApplication(List<LmsLeaveApplication> listLmsLeaveApplication) {
		this.listLmsLeaveApplication = listLmsLeaveApplication;
	}
	
	/*public LmsHolidayRecord getLmsHolidayRecord() {
		return lmsHolidayRecord;
	}

	public void setLmsHolidayRecord(LmsHolidayRecord lmsHolidayRecord) {
		this.lmsHolidayRecord = lmsHolidayRecord;
	}*/
	public List<LmsHolidayRecord> getListLmsHolidayRecord() {
		return listLmsHolidayRecord;
	}
	
	public void setListLmsHolidayRecord(List<LmsHolidayRecord> listLmsHolidayRecord) {
		this.listLmsHolidayRecord = listLmsHolidayRecord;
	}

	
}




