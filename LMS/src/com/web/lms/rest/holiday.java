package com.web.lms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsHolidayRecordHome;
import com.web.lms.model.LmsHolidayRecord;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class holiday {

	@Autowired
	private LmsHolidayRecordHome lmsHolidayRecordHome;

	@RequestMapping(value = "/holidaymanagement", method = RequestMethod.POST) // Create new holiday information
	public ResponseEntity<ResponseWrapper> doAddition(@RequestBody LmsHolidayRecord lmsHolidayRecord) {

		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {

			try {
				int lmsholidayid = lmsHolidayRecordHome.persist(lmsHolidayRecord);
			} catch (Exception ex) {
				ex.printStackTrace();
				responseWrapper.setMessage("Failed to create User.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			responseWrapper.setMessage("Success. Holiday information is created");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

		} catch (Exception ex) {

			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@RequestMapping(value = "/updateholidayrecord", method = RequestMethod.PUT) // Update holiday record.
	public ResponseEntity<ResponseWrapper> updateholidayrecord(@RequestBody LmsHolidayRecord lmsHolidayRecord) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			lmsHolidayRecordHome.merge(lmsHolidayRecord); // For Update

		}

		catch (Exception ex) {
			ex.printStackTrace();
			responseWrapper.setMessage("Failed to create User.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

		responseWrapper.setMessage("Success. Request is updated");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteholidayrecord", method = RequestMethod.PUT) // Update holiday record.
	public ResponseEntity<ResponseWrapper> deleteholidayrecord(@RequestBody Integer holidayrecord_id) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		LmsHolidayRecord lmsHolidayRecord_n = lmsHolidayRecordHome.findById(holidayrecord_id);
		try {

			if (lmsHolidayRecord_n != null) {

				//lmsHolidayRecordHome.merge(lmsHolidayRecord_n);
				lmsHolidayRecordHome.remove(lmsHolidayRecord_n); // For Delete

			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
			responseWrapper.setMessage("Failed to create User.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

		responseWrapper.setMessage("Success. Request is updated");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

	}

}
