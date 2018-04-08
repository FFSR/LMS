package com.web.lms.rest;

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

import com.web.lms.dao.LmsUserHome;
import com.web.lms.model.LmsUser;
import com.web.lms.wrapper.ResponseWrapper;

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
			
			//String office = lmsUser.getLmsOfficeLocation();
			String userName = lmsUser.getName();
			//String division = lmsUser.getLmsDivision();
			//String designation = lmsUser.getLmsDesignation();
			//String ministry = lmsUser.getLmsMinistry();
			//String Section = lmsUser.getLmsSection();
			String nid = lmsUser.getNid();
			String nationality = lmsUser.getNationality();
			String passport = lmsUser.getPassport();
			String mobile = lmsUser.getMobilePersonal();
			String telephone = lmsUser.getPhone();
			String email = lmsUser.getEmail();
			String fax = lmsUser.getFax();
			//String joiningdate = lmsUser.getJoiningDate();
			String gender = lmsUser.getGender();
		//	String supervisoremail = lmsUser.
			String address = lmsUser.getAddress();

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
	
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.PUT)
	public ResponseEntity<ResponseWrapper> doChangePassword(@RequestBody LmsUser lmsUser) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		

		try {
			
			String newpassword = lmsUser.getPassword();
			String email = lmsUser.getEmail();
			

			try {
				lmsUser = lmsUserHome.findByEmailID(email);				
				lmsUser.setPassword(newpassword);
				lmsUserHome.merge(lmsUser);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				responseWrapper.setMessage("Failed to change password.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
			
			responseWrapper.setMessage("Success. Password changed");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

		} catch (Exception ex) {

			responseWrapper.setMessage("Fail."+ex.getMessage());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@RequestMapping(value = "/getUserList/", method = RequestMethod.GET)
	public ResponseEntity<List<LmsUser>> getlog() {

		List<LmsUser> listLmsUser = lmsUserHome.findAllUsers();
		
		if(listLmsUser == null) {
			return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/manageuser/{userid}", method=RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> manageuser(@PathVariable Integer userid){
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		List<LmsUser> lmsUser = lmsUserHome.findUserByUserID(userid);
		
		if(lmsUser.size()>0) {
			
			responseWrapper.setListLmsuser(lmsUser);
			
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
		
		responseWrapper.setMessage("Fail. Data not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
	
	
	@RequestMapping(value = "/updateuserprofile", method = RequestMethod.PUT)
	public ResponseEntity<ResponseWrapper> updateuserprofile(@RequestBody LmsUser lmsUser) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {
			//LmsUser user = new LmsUser();
			
			//String office = lmsUser.getLmsOfficeLocation();
			String userName = lmsUser.getName();
			//String division = lmsUser.getLmsDivision();
			//String designation = lmsUser.getLmsDesignation();
			//String ministry = lmsUser.getLmsMinistry();
			//String Section = lmsUser.getLmsSection();
			String nid = lmsUser.getNid();
			String nationality = lmsUser.getNationality();
			String passport = lmsUser.getPassport();
			String mobile = lmsUser.getMobilePersonal();
			String telephone = lmsUser.getPhone();
			String email = lmsUser.getEmail();
			String fax = lmsUser.getFax();
			//String joiningdate = lmsUser.getJoiningDate();
			String gender = lmsUser.getGender();
		//	String supervisoremail = lmsUser.
			String address = lmsUser.getAddress();

				//LmsUser user = new LmsUser();

				

				try  {	
					
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

}



	
	


