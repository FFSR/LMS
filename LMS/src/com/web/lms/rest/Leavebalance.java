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
import com.web.lms.model.LmsLeaveBalance;
import com.web.lms.model.LmsUser;

@RestController
public class Leavebalance {
	
	@Autowired
	private com.web.lms.dao.LmsLeaveBalanceHome LmsLeaveBalanceHome;
	
	@Autowired
	private HttpSession httpSession;

	
	@RequestMapping(value="/leavehistory/{userid}", method=RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> leavehistory(@PathVariable Integer userid){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		List<LmsLeaveBalance> lmsLeaveBalances = LmsLeaveBalanceHome.findLeaveBalanceByUserID(userid);
		
		if(lmsLeaveBalances.size()>0) {
			
			//responseWrapper.setListLmsLeaveBalance(lmsLeaveBalances);
			
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		
		responseWrapper.setMessage("Fail. User Name or Password not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
	

}
