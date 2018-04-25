package com.web.lms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.lms.dao.LmsSectionHome;
import com.web.lms.model.LmsSection;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class Section {

	@Autowired
	private LmsSectionHome LmsSectionHome;
	
	@RequestMapping(value="/getAllSectionData", method=RequestMethod.GET)
	public ResponseEntity<List<LmsSection>> getAllSection() {
		
		List<LmsSection> listLmssection = new ArrayList<>();
		
		try {
			listLmssection = LmsSectionHome.getAllsection();
			
			return new ResponseEntity<List<LmsSection>>(listLmssection, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsSection>>(listLmssection, HttpStatus.EXPECTATION_FAILED);
			
		}
		
		
	}
}
