package com.web.lms.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsEventLogHome;
import com.web.lms.model.LmsEventLog;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class eventlog {
	
	@Autowired
	private LmsEventLogHome lmsEventLogHome;
	
	@RequestMapping(value = "eventlog/{startdate}/{enddate}", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> generateeventlog(@PathVariable("startdate") Date startdate,@PathVariable("enddate") Date enddate ) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			//List<LmsWfRequest> listLmsWfRequest = lmsWfRequestHome.findRequestByUserAndDateRange(userID,startdate,enddate);
			List<LmsEventLog> listLmsEventLog = lmsEventLogHome.findeventlogDateRange(startdate,enddate);

			if (listLmsEventLog.size() > 0) {
				
				responseWrapper.setMessage("Success. Leave request found.");
				responseWrapper.setListLmsEventLog(listLmsEventLog);
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
				
			} else {
				
				responseWrapper.setMessage("Fail. No record found.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

		} catch (Exception ex) {
			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}
	}

}
