package com.web.lms.wrapper;

import java.util.List;

import com.web.lms.model.LmsWftRoleUserMap;

public class ResponseWrapperWorkFlowManagement {
	
	String message;
	
	List<LmsWftRoleUserMap> listLmsWftRoleUserMap;
	
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
}




