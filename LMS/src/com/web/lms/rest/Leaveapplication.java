package com.web.lms.rest;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsLeaveApplicationHome;
import com.web.lms.dao.LmsLeaveTypeHome;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.dao.LmsWfRequestHome;
import com.web.lms.dao.LmsWfRequestHopHome;
import com.web.lms.dao.LmsWftFlowControlHome;
import com.web.lms.dao.LmsWftHopHome;
import com.web.lms.dao.LmsWftRequestHopRolePageMapHome;
import com.web.lms.dao.LmsWftRequestTypeHome;
import com.web.lms.dao.LmsWftRoleHome;
import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;
import com.web.lms.wrapper.ResponseWrapper;


@RestController
public class Leaveapplication {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private LmsWftRoleHome lmsWftRoleHome;
	@Autowired
	private LmsWftHopHome lmsWftHopHome;
	@Autowired
	private LmsWftRequestTypeHome lmsWftRequestTypeHome;
	@Autowired
	private LmsWftRequestHopRolePageMapHome lmsWftRequestHopRolePageMapHome;
	@Autowired
	private LmsWftFlowControlHome lmsWftFlowControlHome;
	
	@Autowired
	private LmsWfRequestHome lmsWfRequestHome;
	@Autowired
	private LmsWfRequestHopHome lmsWfRequestHopHome;
	
	@Autowired
	private LmsUserHome lmsUserHome;
	@Autowired
	private LmsLeaveTypeHome lmsLeaveTypeHome;
	
	@Autowired
	private LmsLeaveApplicationHome lmsLeaveApplicationHome;
	
	@RequestMapping(value = "/applicationforleave", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> doLeaveSubmission(@RequestBody LmsLeaveApplication lmsLeaveApplication) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
						
			try {				
				// Convert to this time
				// Start date = " 00:00:00";
				// End Date = " 23:59:59";
				
				lmsLeaveApplication.setFromDate(getStartOfDay(lmsLeaveApplication.getFromDate()));
				lmsLeaveApplication.setToDate(getEndOfDay(lmsLeaveApplication.getToDate()));
				
			int lmsleaveapplicationid = lmsLeaveApplicationHome.persist(lmsLeaveApplication);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				responseWrapper.setMessage("Failed to create User.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
			
			responseWrapper.setMessage("Success. User has created");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

	}
	
	 private Date getStartOfDay(Date date) {
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    int year = calendar.get(Calendar.YEAR);
		    int month = calendar.get(Calendar.MONTH);
		    int day = calendar.get(Calendar.DATE);
		    calendar.set(year, month, day, 0, 0, 0);
		    return calendar.getTime();
		}

		private Date getEndOfDay(Date date) {
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    int year = calendar.get(Calendar.YEAR);
		    int month = calendar.get(Calendar.MONTH);
		    int day = calendar.get(Calendar.DATE);
		    calendar.set(year, month, day, 23, 59, 59);
		    return calendar.getTime();
		}
}
