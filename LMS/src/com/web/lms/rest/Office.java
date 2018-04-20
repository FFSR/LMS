package com.web.lms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsOfficeLocationHome;
import com.web.lms.model.LmsOfficeLocation;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Office {

	@Autowired
	private LmsOfficeLocationHome LmsOfficeLocationHome;
	
	@RequestMapping(value="/getAllOfficeData", method=RequestMethod.GET)
	public ResponseEntity<List<LmsOfficeLocation>> getAllOffice() {
		
		List<LmsOfficeLocation> listLmsOfficeLocation = new ArrayList<>();
		
		try {
			listLmsOfficeLocation = LmsOfficeLocationHome.getAlloffice();
			
			return new ResponseEntity<List<LmsOfficeLocation>>(listLmsOfficeLocation, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsOfficeLocation>>(listLmsOfficeLocation, HttpStatus.EXPECTATION_FAILED);
			
		}
		
		
	}
}
