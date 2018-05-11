package com.web.lms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.web.lms.dao.LmsDepartmentHome;
import com.web.lms.model.LmsDepartment;
import com.web.lms.wrapper.ResponseWrapper;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Department {

	@Autowired
	private LmsDepartmentHome lmsDepartmentHome;
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value="/getAllDepartmentData", method=RequestMethod.GET)
	public ResponseEntity<List<LmsDepartment>> getAllDepartment() {
		
		List<LmsDepartment> listLmsdepartment = new ArrayList<>();
		
		try {
			listLmsdepartment = lmsDepartmentHome.getAlldepartment();
			
			return new ResponseEntity<List<LmsDepartment>>(listLmsdepartment, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsDepartment>>(listLmsdepartment, HttpStatus.EXPECTATION_FAILED);
			
		}
		
		
	}
	
}
