package com.web.lms.wrapper;

import com.web.lms.model.LmsLeaveBalance;

public class ResponseWrapperLeaveRule {
	
	String message;
	String holidayDate;	
	LmsLeaveBalance lmsLeaveBalance;
	Integer forwardHolidayCount;
	Integer backwardHolidayCount;
	Integer minimumHolidayConsider;
	Integer numberOfDayConsider;
	long numberOfDaysApplied;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getHolidayDate() {
		return holidayDate;
	}
	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}
	public LmsLeaveBalance getLmsLeaveBalance() {
		return lmsLeaveBalance;
	}
	public void setLmsLeaveBalance(LmsLeaveBalance lmsLeaveBalance) {
		this.lmsLeaveBalance = lmsLeaveBalance;
	}
	public Integer getForwardHolidayCount() {
		return forwardHolidayCount;
	}
	public void setForwardHolidayCount(Integer forwardHolidayCount) {
		this.forwardHolidayCount = forwardHolidayCount;
	}
	public Integer getBackwardHolidayCount() {
		return backwardHolidayCount;
	}
	public void setBackwardHolidayCount(Integer backwardHolidayCount) {
		this.backwardHolidayCount = backwardHolidayCount;
	}
	public Integer getMinimumHolidayConsider() {
		return minimumHolidayConsider;
	}
	public void setMinimumHolidayConsider(Integer minimumHolidayConsider) {
		this.minimumHolidayConsider = minimumHolidayConsider;
	}
	public Integer getNumberOfDayConsider() {
		return numberOfDayConsider;
	}
	public void setNumberOfDayConsider(Integer numberOfDayConsider) {
		this.numberOfDayConsider = numberOfDayConsider;
	}
	public long getNumberOfDaysApplied() {
		return numberOfDaysApplied;
	}
	public void setNumberOfDaysApplied(long numberOfDaysApplied) {
		this.numberOfDaysApplied = numberOfDaysApplied;
	}
}




