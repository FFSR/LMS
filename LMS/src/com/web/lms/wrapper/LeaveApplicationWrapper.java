package com.web.lms.wrapper;

import com.web.lms.model.LmsLeaveType;

public class LeaveApplicationWrapper {

	private LmsLeaveType lmsLeaveType;

	private String eligibility;
	private String insertDate;
	private String insertBy;
	private String updatDate;						
	private String updateBy;
	
	public LmsLeaveType getLmsLeaveType() {
		return lmsLeaveType;
	}
	public void setLmsLeaveType(LmsLeaveType lmsLeaveType) {
		this.lmsLeaveType = lmsLeaveType;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getInsertBy() {
		return insertBy;
	}
	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy;
	}
	public String getUpdatDate() {
		return updatDate;
	}
	public void setUpdatDate(String updatDate) {
		this.updatDate = updatDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	
	
}
