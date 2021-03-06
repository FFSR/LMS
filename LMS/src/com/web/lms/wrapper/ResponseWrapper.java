package com.web.lms.wrapper;

import java.util.List;

import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsLeaveBalance;
import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsWfRequest;
import com.web.lms.model.LmsWfRequestHop;
import com.web.lms.model.LmsHolidayRecord;
import com.web.lms.model.LmsDropdown;
import com.web.lms.model.LmsAttachment;


public class ResponseWrapper {
	String message;
	
	Integer userid;
	Integer leavetypeid;
	Integer leaveapplicationid;
	
	LmsLeaveBalance lmsLeaveBalance;
	
	List<LmsLeaveBalance> listLmsLeaveBalance;
	
	LmsUser lmsuser;
	
	LmsUser lmssupervisor;
	
	List<LmsUser> listLmsuser;
	
	List<LmsUser> listlmssupervisor;
	
	
	
	LmsLeaveApplication lmsLeaveApplication;
	
	List<LmsLeaveApplication> listLmsLeaveApplication;
	
	LmsHolidayRecord lmsHolidayRecord;
	
	List<LmsHolidayRecord> listLmsHolidayRecord;
	
	List<LmsDropdown> listLmsDropdown;

	List<LmsWfRequestHop> listLmsWfRequestHops;
	
	List<LmsWfRequest> listLmsWfRequest;
	
	List<LmsAttachment> listLmsAttatchment;

	public List<LmsWfRequest> getListLmsWfRequest() {
		return listLmsWfRequest;
	}

	public void setListLmsWfRequest(List<LmsWfRequest> listLmsWfRequest) {
		this.listLmsWfRequest = listLmsWfRequest;
	}

	public List<LmsDropdown> getListLmsDropdown() {
		return listLmsDropdown;
	}

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
	
	public LmsUser getLmssupervisor() {
		return lmssupervisor;
	}
	
	public void setLmssupervisor(LmsUser lmssupervisor) {
		this.lmssupervisor = lmssupervisor;
	}
	
	public List<LmsUser> getListLmsuser() {
		return listLmsuser;
	}

	public void setListLmsuser(List<LmsUser> listLmsuser) {
		this.listLmsuser = listLmsuser;
	}

	public List<LmsUser> getListLmssupervisor() {
		return listlmssupervisor;
	}
	
	public void setListLmssupervisor(List<LmsUser> listlmssupervisor) {
		this.listlmssupervisor = listlmssupervisor;
	}
	public List<LmsLeaveApplication> getListLmsLeaveApplication() {
		return listLmsLeaveApplication;
	}

	public void setListLmsLeaveApplication(List<LmsLeaveApplication> listLmsLeaveApplication) {
		this.listLmsLeaveApplication = listLmsLeaveApplication;
	}
	
	public List<LmsHolidayRecord> getListLmsHolidayRecord() {
		return listLmsHolidayRecord;
	}
	
	public void setListLmsHolidayRecord(List<LmsHolidayRecord> listLmsHolidayRecord) {
		this.listLmsHolidayRecord = listLmsHolidayRecord;
	}
	
	public void setListLmsDropdown(List<LmsDropdown> listLmsDropdown) {
		this.listLmsDropdown = listLmsDropdown;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getLeavetypeid() {
		return leavetypeid;
	}

	public void setLeavetypeid(Integer leavetypeid) {
		this.leavetypeid = leavetypeid;
	}

	public Integer getLeaveapplicationid() {
		return leaveapplicationid;
	}

	public void setLeaveapplicationid(Integer leaveapplicationid) {
		this.leaveapplicationid = leaveapplicationid;
	}

	public List<LmsWfRequestHop> getListLmsWfRequestHops() {
		return listLmsWfRequestHops;
	}

	public void setListLmsWfRequestHops(List<LmsWfRequestHop> listLmsWfRequestHops) {
		this.listLmsWfRequestHops = listLmsWfRequestHops;
	}

	public List<LmsAttachment> getListLmsAttatchment() {
		return listLmsAttatchment;
	}

	public void setListLmsAttatchment(List<LmsAttachment> listLmsAttatchment) {
		this.listLmsAttatchment = listLmsAttatchment;
	}
	
	
}




