package com.web.lms.wrapper;

import java.util.List;

import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsUserRoleMap;
import com.web.lms.model.LmsWfRequest;
import com.web.lms.model.LmsWfRequestHop;
import com.web.lms.model.LmsWftRoleUserMap;

public class ResponseWrapperWorkFlowManagement {
	
	String message;
	
	List<LmsWftRoleUserMap> listLmsWftRoleUserMap;
	
	List<LmsUserRoleMap> listLmsUserRoleMap;
	
	LmsWfRequestHop lmsWfRequestHop;
	
	LmsWfRequest lmsWfRequest;
	
	LmsLeaveApplication lmsLeaveApplication;
	
	public List<LmsWftRoleUserMap> getListLmsWftRoleUserMap() {
		return listLmsWftRoleUserMap;
	}

	public void setListLmsWftRoleUserMap(List<LmsWftRoleUserMap> listLmsWftRoleUserMap) {
		this.listLmsWftRoleUserMap = listLmsWftRoleUserMap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LmsWfRequestHop getLmsWfRequestHop() {
		return lmsWfRequestHop;
	}

	public void setLmsWfRequestHop(LmsWfRequestHop lmsWfRequestHop) {
		this.lmsWfRequestHop = lmsWfRequestHop;
	}

	public LmsWfRequest getLmsWfRequest() {
		return lmsWfRequest;
	}

	public void setLmsWfRequest(LmsWfRequest lmsWfRequest) {
		this.lmsWfRequest = lmsWfRequest;
	}

	public LmsLeaveApplication getLmsLeaveApplication() {
		return lmsLeaveApplication;
	}

	public void setLmsLeaveApplication(LmsLeaveApplication lmsLeaveApplication) {
		this.lmsLeaveApplication = lmsLeaveApplication;
	}

	public List<LmsUserRoleMap> getListLmsUserRoleMap() {
		return listLmsUserRoleMap;
	}

	public void setListLmsUserRoleMap(List<LmsUserRoleMap> listLmsUserRoleMap) {
		this.listLmsUserRoleMap = listLmsUserRoleMap;
	}
	
	
}




