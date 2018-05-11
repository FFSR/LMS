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
import com.web.lms.wrapper.ResponseWrapper;

import com.web.lms.dao.LmsUserHome;
import com.web.lms.dao.LmsLeaveApplicationHome;
import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsUser;

@RestController
public class Leave {

	
	
	@Autowired
	private com.web.lms.dao.LmsLeaveApplicationHome LmsLeaveApplicationHome;
	
	@Autowired
	private HttpSession httpSession;

	
	@RequestMapping(value="/leave/{user_id}", method=RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> leave(@PathVariable Integer user_id){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		List<LmsLeaveApplication> LmsLeaveApplication = LmsLeaveApplicationHome.findLeaveApplicationByUserID(user_id);
		
		if(LmsLeaveApplication.size()>0) {
			
			responseWrapper.setListLmsLeaveApplication(LmsLeaveApplication);
			
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		
		responseWrapper.setMessage("Fail. User Name or Password not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
	
	
}



	
	


