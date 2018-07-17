package com.web.lms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.web.lms.dao.LmsDivisionHome;
import com.web.lms.model.LmsDivision;
import com.web.lms.model.LmsHolidayRecord;
import com.web.lms.wrapper.ResponseWrapper;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Division {

	@Autowired
	private LmsDivisionHome lmsDivisionHome;
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value="/getAllDivisionData", method=RequestMethod.GET)
	public ResponseEntity<List<LmsDivision>> getAllDivision() {
		
		List<LmsDivision> listLmsdivision = new ArrayList<>();
		
		try {
			listLmsdivision = lmsDivisionHome.getAlldivision();
			
			
			return new ResponseEntity<List<LmsDivision>>(listLmsdivision, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsDivision>>(listLmsdivision, HttpStatus.EXPECTATION_FAILED);
			
		}
		
		
	}
	
	@RequestMapping(value = "/divisioninfo", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> doAddition(@RequestBody LmsDivision lmsDivision) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			
			try {
			int lmsministryid = lmsDivisionHome.persist(lmsDivision);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				responseWrapper.setMessage("Failed to create User.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
			
			responseWrapper.setMessage("Success. User has created");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

		} catch (Exception ex) {

		responseWrapper.setMessage("Fail."+ex.getMessage());
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	@RequestMapping(value = "/deleteDivision", method = RequestMethod.PUT) // Update holiday record.
	public ResponseEntity<ResponseWrapper> deleteholidayrecord(@RequestBody Integer division_id) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		LmsDivision lmsDivision = lmsDivisionHome.findById(division_id);
		try {

			if (lmsDivision != null) {

				//lmsHolidayRecordHome.merge(lmsHolidayRecord_n);
				lmsDivisionHome.remove(lmsDivision); // For Delete

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
