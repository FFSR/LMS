package com.web.lms.rest;

import java.util.List;

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
import com.web.lms.model.LmsUser;
import com.web.lms.wrapper.ResponseWrapper;
import com.web.lms.wrapper.LeaveApplicationWrapper;

@RestController
public class Testleaveapplication {
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private LmsLeaveApplicationHome lmsLeaveApplicationHome;
	
	//@Autowired
	//private LmsLeaveApplication lmsLeaveApplication;
	
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
	
	@RequestMapping(value="/manageleave/{userid}", method=RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> manageuser(@PathVariable Integer userid){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Test Message");
		List<LmsLeaveApplication> lmsLeaveApplication = lmsLeaveApplicationHome.findLeaveApplicationByUserID(userid);
		
		if(lmsLeaveApplication.size()>0) {
			
	   responseWrapper.setListLmsLeaveApplication(lmsLeaveApplication);
			
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		
		responseWrapper.setMessage("Fail. Data not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
	
	@RequestMapping(value = "/updateuserleave", method = RequestMethod.PUT)
	public ResponseEntity<ResponseWrapper> updateuserleave(@RequestBody LmsLeaveApplication lmsLeaveApplication) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();

				try  {	
					
					lmsLeaveApplicationHome.merge(lmsLeaveApplication); // For Update
				
				}
				
				catch(Exception ex) {
					ex.printStackTrace();
					responseWrapper.setMessage("Failed to create User.");
					return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
				}
				
				responseWrapper.setMessage("Success. User has created");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

		}



}
