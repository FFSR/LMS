package com.web.lms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsDropdownHome;
import com.web.lms.model.LmsDivision;
import com.web.lms.model.LmsDropdown;
import com.web.lms.model.LmsUser;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Dropdown {
	
	@Autowired
	private LmsDropdownHome lmsDropdownHome;

	
	@RequestMapping(value="/getDropdownData", method=RequestMethod.GET)
	
		public ResponseEntity<List<LmsDropdown>> getAllDropdown() {
		
		List<LmsDropdown> listLmsdropdown = new ArrayList<>();
		
		try {
			listLmsdropdown = lmsDropdownHome.getAllDropdown();
			
			return new ResponseEntity<List<LmsDropdown>>(listLmsdropdown, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsDropdown>>(listLmsdropdown, HttpStatus.EXPECTATION_FAILED);
			
		}
		
		
	}
	
	@RequestMapping(value="/getDropdownDataByName/{dropdownname}", method=RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> manageuser(@PathVariable String dropdownname){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		
		List<LmsDropdown> lmsDropdown = lmsDropdownHome.findByDropdownName(dropdownname);
		
		if(lmsDropdown.size()>0) {
			
			responseWrapper.setListLmsDropdown(lmsDropdown);
			
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		
		responseWrapper.setMessage("Fail. Data not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}		
	
	
}

