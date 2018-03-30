package com.web.lms.rest;

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

import com.web.lms.dao.LmsMinistryHome;

import com.web.lms.model.LmsMinistry;
import com.web.lms.model.LmsUser;

@RestController
public class Ministry {
	
	@Autowired
	private LmsMinistryHome lmsMinistryHome;
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value = "/ministryinfo", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> doAddition(@RequestBody LmsMinistry lmsMinistry) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			//LmsUser user = new LmsUser();

			/*String userName = lmsUser.getName();
			String nid = lmsUser.getNid();
			String email = lmsUser.getEmail();
			String gender = lmsUser.getGender();*/
			try {
			int lmsministryid = lmsMinistryHome.persist(lmsMinistry);
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
}

