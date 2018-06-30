package com.web.lms.wrapper;

import java.util.List;

import com.web.lms.model.LmsRole;
import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsWftRole;

public class UserWrapper {
	
	LmsUser lmsuser;
	List<LmsRole> lmsRoles;
	List<LmsWftRole> lmsWftRoles;
	
	public LmsUser getLmsuser() {
		return lmsuser;
	}
	public void setLmsuser(LmsUser lmsuser) {
		this.lmsuser = lmsuser;
	}
	public List<LmsRole> getLmsRoles() {
		return lmsRoles;
	}
	public void setLmsRoles(List<LmsRole> lmsRoles) {
		this.lmsRoles = lmsRoles;
	}
	public List<LmsWftRole> getLmsWftRoles() {
		return lmsWftRoles;
	}
	public void setLmsWftRoles(List<LmsWftRole> lmsWftRoles) {
		this.lmsWftRoles = lmsWftRoles;
	}
}
