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
import com.web.lms.model.LmsDropdown;

@RestController
public class Dropdown {
	
	@Autowired
	private LmsDropdownHome lmsDropdownHome;

	
	@RequestMapping(value="/getDropdownData/{dropdownName}", method=RequestMethod.GET)
	public ResponseEntity<List<LmsDropdown>> getDropdownData(@PathVariable("dropdownName") String dropdownName){
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<LmsDropdown> listLmsDropdown = new ArrayList(); 
		try {
			listLmsDropdown = lmsDropdownHome.findByDropdownName(dropdownName);
			if(listLmsDropdown.isEmpty()) {
				return new ResponseEntity<List<LmsDropdown>>(listLmsDropdown, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<LmsDropdown>>(listLmsDropdown, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsDropdown>>(listLmsDropdown, HttpStatus.EXPECTATION_FAILED);
		}
		
	}
}
