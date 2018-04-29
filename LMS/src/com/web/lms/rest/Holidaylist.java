package com.web.lms.rest;

import java.util.ArrayList;
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
import com.web.lms.dao.LmsHolidayRecordHome;
import com.web.lms.dao.LmsLeaveApplicationHome;
import com.web.lms.model.LmsHolidayRecord;

@RestController
public class Holidaylist {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private LmsHolidayRecordHome lmsHolidayRecordHome;

	@RequestMapping(value="/holidaygridshow/", method=RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> getlog(){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Test Message");
		List<LmsHolidayRecord> lmsHolidayRecord = lmsHolidayRecordHome.findAllHoliday();
		
		if(lmsHolidayRecord.size()>0) {
			
	   responseWrapper.setListLmsHolidayRecord(lmsHolidayRecord);
			
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		
		responseWrapper.setMessage("Fail. Data not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
}
