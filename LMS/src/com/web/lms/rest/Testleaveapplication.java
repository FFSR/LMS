package com.web.lms.rest;

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
import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.wrapper.ResponseWrapper;
import com.web.lms.wrapper.LeaveApplicationWrapper;

@RestController
public class Testleaveapplication {
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private LmsLeaveApplicationHome lmsLeaveApplicationHome;
	
	@RequestMapping(value = "/testleave", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> doLeaveSubmission(@RequestBody LmsLeaveApplication leaveApplication) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		
		
			try {
			int lmsleaveapplicationid = lmsLeaveApplicationHome.persist(leaveApplication);
			//lmsLeaveApplicationHome.persist(lmsLeaveApplication);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				//responseWrapper.setMessage("Failed to create User.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
			
			//responseWrapper.setMessage("Success. User has created");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);	

	}


}
