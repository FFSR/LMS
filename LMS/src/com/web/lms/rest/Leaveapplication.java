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
public class LeaveApplication {
	
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
	
	@RequestMapping(value = "/getleaveapplication/{id}", method = RequestMethod.GET)
	public ResponseEntity<LmsLeaveApplication> getLeaveApplication(@PathVariable Integer id) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		LmsLeaveApplication lmsLeaveApplication = new LmsLeaveApplication();
			try {
			lmsLeaveApplication= lmsLeaveApplicationHome.findById(id);
			
			if (lmsLeaveApplication!=null) {
			
				return new ResponseEntity<LmsLeaveApplication>(lmsLeaveApplication, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<LmsLeaveApplication>(lmsLeaveApplication, HttpStatus.EXPECTATION_FAILED);
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				responseWrapper.setMessage("Failed to create User.");
				return new ResponseEntity<LmsLeaveApplication>(lmsLeaveApplication, HttpStatus.EXPECTATION_FAILED);
			}

		

	}
	@RequestMapping(value="/generaterequest/{userid}/{leavetypeid}", method=RequestMethod.POST)
	
	public ResponseEntity<ResponseWrapper> generateRequest(@PathVariable("userid") Integer userid, @PathVariable("leavetypeid") Integer leavetypeid){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		
		try {
			
			// Validate User
			LmsUser user = lmsUserHome.findById(userid);
			if(user == null) {
				responseWrapper.setMessage("This userid is not available in database.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);				
			}

			// Validate Leave Type
			LmsLeaveType leaveType = lmsLeaveTypeHome.findById(leavetypeid);
			
			if(leaveType == null) {
				responseWrapper.setMessage("This Leave Type is not available in database.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);				
			}
			
			// Find 
			/*if(leaveType.getType().equals(LEAVETYPE.EARN)) {
				
				
			}*/
			
			
			
			responseWrapper.setMessage("Success. Your request is successfully generated.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		catch(Exception ex) {		
			responseWrapper.setMessage("Fail."+ex.getMessage());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);			
		}		
	}
	
}
