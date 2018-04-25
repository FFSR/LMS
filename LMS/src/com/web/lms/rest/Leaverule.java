package com.web.lms.rest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsLeaveApplicationHome;
import com.web.lms.dao.LmsLeaveBalanceHome;
import com.web.lms.dao.LmsLeaveTypeHome;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.enumcollection.DECISION;
import com.web.lms.enumcollection.LEAVETYPE;
import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsLeaveBalance;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Leaverule {
	
	@Autowired
	private LmsUserHome lmsUserHome;	
	@Autowired
	private LmsLeaveTypeHome lmsLeaveTypeHome;
	@Autowired
	private LmsLeaveBalanceHome lmsLeaveBalanceHome;
	@Autowired
	private LmsLeaveApplicationHome lmsLeaveApplicationHome;

	
	@RequestMapping(value = "/leaverule/{userid}/{leavetypeid}/{startdate}/{enddate}/", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> generateRequest(@PathVariable("userid") Integer userid,
			@PathVariable("leavetypeid") Integer leavetypeid, @PathVariable("startdate") Date startdate, @PathVariable("enddate") Date enddate) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			// Validate User
			LmsUser user = lmsUserHome.findById(userid);
			if (user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			// Validate Leave Type
			LmsLeaveType leaveType = lmsLeaveTypeHome.findById(leavetypeid);

			if (leaveType == null) {
				responseWrapper.setMessage("This Leave Type is not available in database.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
			
			// Validate Date : Start date is Null
			if(startdate == null) {
				responseWrapper.setMessage("Start date is Null.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);				
			}
			
			// Validate Date : End date is Null
			if(enddate == null) {
				responseWrapper.setMessage("End date is Null.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);				
			}

			// Validate Date : End date is advanced than start date
			int dateValidator = startdate.compareTo(enddate);
			if(dateValidator<0) {
				responseWrapper.setMessage("Enddate is advanced than startdate.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);				
			}

			String replayMessage = validateWithLeaveRulet(user,leaveType,startdate,enddate);
			
			if(replayMessage.contains("OK")) {
				
				responseWrapper.setMessage("Success. Leave rule validation complete.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
			
			}else {
				responseWrapper.setMessage(replayMessage);
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);					
			}
			
			
		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}

	private String validateWithLeaveRulet(LmsUser user, LmsLeaveType leaveType, Date startdate, Date enddate) {

		String replayMessage="";
		
		LmsLeaveBalance lmsLeaveBalance;	
		
		Date date = new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		String strCurrentYear = Integer.toString(year);
		//int month = cal.get(Calendar.MONTH);
		//int day = cal.get(Calendar.DAY_OF_MONTH);
		
		long numberOfDays = calculateDateDifference(startdate,enddate);		
		
		// Validation 1: Maximum Leave limit exceed.
		if (leaveType.getMaximumDays() != null || leaveType.getMaximumDays() != 0) {
			
			lmsLeaveBalance =	lmsLeaveBalanceHome.findLeaveCountbyUserAndLeaveType(user.getId(), leaveType.getId());
			
			if (leaveType.getMaximumDays() > (lmsLeaveBalance.getLeaveTaken() + lmsLeaveBalance.getLeaveApplied() + numberOfDays)) {
				
				replayMessage = "Validation 1: Maximum Leave limit exceed.";
				return replayMessage;
			}
		}

		// Validation 2: Maximum times limit exceed.
		else if (leaveType.getMaximumTimes() != null || leaveType.getMaximumTimes() != 0) {
			
			List<LmsLeaveApplication> leaveApplications =	lmsLeaveApplicationHome.findLeaveApplicationByUserandLeaveTypeandYear(user.getId(), leaveType.getId(), strCurrentYear);

			if (leaveType.getMaximumTimes() > leaveApplications.size()) {
				
				replayMessage = "Validation 2: Maximum times limit exceed.";
				return replayMessage;
			}
		}
		
		// Validation 3: Maximum leaves at a time limit exceed.
		else if(leaveType.getMaximumAtATime() != null || leaveType.getMaximumAtATime() != 0) {
			if(leaveType.getMaximumAtATime() > numberOfDays) {
				
				replayMessage = "Validation 3: Maximum leaves at a time limit exceed.";
				return replayMessage;
			}			
		}
		
		// Validation 4: Eligibility requirement, number of days from Joining date does not full filled.
		else if(leaveType.getEligibleAfter() != null || leaveType.getEligibleAfter() != 0) {
			
			long numberOfDaysFromJoining = calculateDateDifference(user.getJoiningDate(),startdate);
			
			if(leaveType.getEligibleAfter() > numberOfDaysFromJoining) {
				
				replayMessage = "Validation 4: Eligibility requirement, number of days from Joining date does not full filled.";
				return replayMessage;
			}			
		}
		
		// Validation 5: Eligibility requirement, number of days to resign does not full filled.
		else if(leaveType.getEligibleBefore() != null || leaveType.getEligibleBefore() != 0) {
			
			long numberOfDaysToResign = calculateDateDifference(startdate,user.getResigndate());
			
			if(leaveType.getEligibleBefore() < numberOfDaysToResign) {
				
				replayMessage = "Validation 5: Eligibility requirement, number of days to resign does not full filled.";
				return replayMessage;
			}			
		}
		
		// Validation 6: Leave Type is not ACTIVE.
		else if(leaveType.getStatus() != null || !leaveType.getStatus().equals("")) {
			if(!leaveType.getStatus().equals(LEAVETYPE.ACTIVE)) {
				
				replayMessage = "Validation 6: Leave Type is not ACTIVE.";				
				return replayMessage;
			}			
		}
		
		// Validation 7: Insufficient Leave Balance.
		else if ((leaveType.getIncremental() != null || !leaveType.getIncremental().equals("")) && leaveType.getIncremental().toUpperCase().equals(DECISION.YES)) {
			
			lmsLeaveBalance =	lmsLeaveBalanceHome.findLeaveCountbyUserAndLeaveTypeAndYear(user.getId(), leaveType.getId(), strCurrentYear);
			
			if (lmsLeaveBalance.getLeaveTotal() > (lmsLeaveBalance.getLeaveTaken() + lmsLeaveBalance.getLeaveApplied() + numberOfDays)) {
				
				replayMessage = "Validation 7: Insufficient Leave Balance.";
				return replayMessage;
			}
		}
		return replayMessage;		
	}

	private long calculateDateDifference(Date startdate, Date enddate) {
		
        long diff = enddate.getTime() - startdate.getTime();

        diff = diff / 1000 / 60 / 60 / 24;
		return diff;
	}
}
