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
import com.web.lms.dao.LmsLeaveTypeHome;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;

@RestController
public class User {

	@Autowired
	private LmsUserHome lmsUserHome;
	@Autowired
	private HttpSession httpSession;

	@RequestMapping(value = "/log/{userName}/{password}", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> getlog(@PathVariable("userName") String uName,
			@PathVariable("password") String password) {

		ResponseWrapper responseWrapper = new ResponseWrapper();
		LmsUser lmsUser = lmsUserHome.findByUnameandPassword(uName, password);

		if (lmsUser != null) {
			responseWrapper.setMessage("Success. UserName: " + uName + " Password: " + password);

			httpSession.setAttribute("userName", uName);
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}

		responseWrapper.setMessage("Fail. User Name or Password not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
	
	@RequestMapping(value="/forgetpassword", method=RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> forgetpassword(@RequestBody String emailid){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		LmsUser lmsUser = lmsUserHome.findByEmailID(emailid);
		
		if(lmsUser != null) {
			responseWrapper.setMessage("Success. UserName: "+lmsUser.getName()+" Password: "+lmsUser.getPassword());
			
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		
		responseWrapper.setMessage("Fail. User Name or Password not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
	
	
		@RequestMapping(value = "/registration", method = RequestMethod.POST)
		public ResponseEntity<ResponseWrapper> doRegistration(@RequestBody LmsUser lmsUser) {
			
			ResponseWrapper responseWrapper = new ResponseWrapper();

			try {
				//LmsUser user = new LmsUser();

				String userName = lmsUser.getName();
				String nid = lmsUser.getNid();
				String email = lmsUser.getEmail();
				String gender = lmsUser.getGender();
				

				try {
				int lmsuserid = lmsUserHome.persist(lmsUser);
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
		
		@RequestMapping(value = "/getUserlist/", method = RequestMethod.GET)
		public ResponseEntity<List<LmsUser>> getlog() {

			List<LmsUser> listLmsUser = new ArrayList<>();
			try {
				listLmsUser = lmsUserHome.findAllUser();
			}
			catch(Exception ex) {
				ex.printStackTrace();
				return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.EXPECTATION_FAILED);
			}
			if(listLmsUser == null) {
				return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.EXPECTATION_FAILED);
			}
			
			return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.OK);
			
		}	
		
}
