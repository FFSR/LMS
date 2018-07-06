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

import com.web.lms.dao.LmsWfRequestHome;
import com.web.lms.model.LmsWfRequest;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Report {

	@Autowired
	private LmsWfRequestHome lmsWfRequestHome;

	@RequestMapping(value = "report/{userID}", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> generateRequest(@PathVariable("userID") Integer userID) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			List<LmsWfRequest> listLmsWfRequest = lmsWfRequestHome.findRequestByUserID(userID);

			if (listLmsWfRequest.size() > 0) {
				
				responseWrapper.setMessage("Success. Leave request found.");
				responseWrapper.setListLmsWfRequest(listLmsWfRequest);
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
	
	@RequestMapping(value = "reportSubordinate/{userID}", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> generateRequestSubordinate(@PathVariable("userID") Integer userID) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			List<LmsWfRequest> listLmsWfRequest = lmsWfRequestHome.findRequestBysupervisorID(userID);

			if (listLmsWfRequest.size() > 0) {
				
				responseWrapper.setMessage("Success. Leave request found.");
				responseWrapper.setListLmsWfRequest(listLmsWfRequest);
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

	
	@RequestMapping(value = "report/{userID}/{startdate}/{enddate}/", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> generateRequest(@PathVariable("userID") Integer userID,@PathVariable("startdate") Date startdate,@PathVariable("enddate") Date enddate ) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			//List<LmsWfRequest> listLmsWfRequest = lmsWfRequestHome.findRequestByUserAndDateRange(userID,startdate,enddate);
			List<LmsWfRequest> listLmsWfRequest = lmsWfRequestHome.findRequestByUserAndDateRange(userID,startdate,enddate);

			if (listLmsWfRequest.size() > 0) {
				
				responseWrapper.setMessage("Success. Leave request found.");
				responseWrapper.setListLmsWfRequest(listLmsWfRequest);
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
