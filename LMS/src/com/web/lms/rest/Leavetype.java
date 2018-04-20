package com.web.lms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsLeaveTypeHome;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Leavetype {
	
	@Autowired
	private LmsLeaveTypeHome lmsLeaveTypeHome;
	@Autowired
	private LmsUserHome lmsUserHome;
	
	@RequestMapping(value = "/getLeavetype/", method = RequestMethod.GET)
	//public ResponseEntity<List<LmsLeaveType>> getlog() {
	 public ResponseEntity<List<LmsLeaveType>> getlog() {
		List<LmsLeaveType> listLmsLeaveType = lmsLeaveTypeHome.findAllLeaveType();
		//List<LmsUser> listLmsUser = lmsUserHome.findAllUser();
		
		if(listLmsLeaveType == null) {
			return new ResponseEntity<List<LmsLeaveType>>(listLmsLeaveType, HttpStatus.EXPECTATION_FAILED);
			//return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ResponseEntity<List<LmsLeaveType>>(listLmsLeaveType, HttpStatus.OK);
		//return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.OK);
		
	}

}
