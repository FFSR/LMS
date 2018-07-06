package com.web.lms.wrapper;

import com.web.lms.model.LmsUser;

public class UserWrapper {
	
	LmsUser lmsuser;
	int[] lmsRoles;
	int[] lmsWftRoles;
	
	public LmsUser getLmsuser() {
		return lmsuser;
	}
	public void setLmsuser(LmsUser lmsuser) {
		this.lmsuser = lmsuser;
	}
	public int[] getLmsRoles() {
		return lmsRoles;
	}
	public void setLmsRoles(int[] lmsRoles) {
		this.lmsRoles = lmsRoles;
	}
	public int[] getLmsWftRoles() {
		return lmsWftRoles;
	}
	public void setLmsWftRoles(int[] lmsWftRoles) {
		this.lmsWftRoles = lmsWftRoles;
	}

}
