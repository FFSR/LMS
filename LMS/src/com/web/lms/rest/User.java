package com.web.lms.rest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
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
import com.web.lms.wrapper.UserWrapper;
import com.web.lms.dao.LmsLeaveTypeHome;
import com.web.lms.dao.LmsRoleHome;
import com.web.lms.dao.LmsUserHome;
import com.web.lms.dao.LmsUserRoleMapHome;
import com.web.lms.dao.LmsWftRoleHome;
import com.web.lms.dao.LmsWftRoleUserMapHome;
import com.web.lms.model.LmsLeaveType;
import com.web.lms.model.LmsUser;
import com.web.lms.model.LmsUserRoleMap;
import com.web.lms.model.LmsWftRole;
import com.web.lms.model.LmsWftRoleUserMap;
import com.web.lms.model.LmsRole;
import com.web.lms.utility.ProtectedConfigFile;
import com.web.lms.wrapper.ResponseWrapper;

@RestController
public class User {

	@Autowired
	private LmsUserHome lmsUserHome;
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private LmsWftRoleUserMapHome lmsWftRoleUserMapHome;
	@Autowired
	private LmsUserRoleMapHome lmsUserRoleMapHome;
	@Autowired
	private LmsRoleHome lmsRoleHome;
	@Autowired
	private LmsWftRoleHome lmsWftRoleHome;

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

	@RequestMapping(value = "/forgetpassword", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> forgetpassword(@RequestBody String emailid) {

		ResponseWrapper responseWrapper = new ResponseWrapper();
		LmsUser lmsUser = lmsUserHome.findByEmailID(emailid);
		
		try {
			lmsUser.setPassword(ProtectedConfigFile.decrypt(lmsUser.getPassword()));
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		if (lmsUser != null) {
			responseWrapper
					.setMessage("Success. UserName: " + lmsUser.getName() + " Password: " + lmsUser.getPassword());
			httpSession.setAttribute("userName", lmsUser.getName());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}

		responseWrapper.setMessage("Fail. User Name or Password not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> doRegistration(@RequestBody LmsUser lmsUser) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		LmsUser lmsUserValidate = null;

		try {

			lmsUserValidate = lmsUserHome.findByNID(lmsUser.getNid());

			if (lmsUserValidate != null) {

				responseWrapper.setMessage("User is available with this NID.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			responseWrapper.setMessage("Registration failed. Same NID created.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

		try {

			lmsUser.setPassword(ProtectedConfigFile.encrypt(lmsUser.getPassword()));
			lmsUser.setInsertDate(new Date());

			try {

				int lmsuserid = lmsUserHome.persist(lmsUser);
			} catch (Exception ex) {
				ex.printStackTrace();
				responseWrapper.setMessage("Failed to create User.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}

			responseWrapper.setMessage("Success. User has created");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

		} catch (Exception ex) {

			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@RequestMapping(value = "/changepassword/{newpassword}/{oldpassword}/{userID}/", method = RequestMethod.PUT)
	public ResponseEntity<ResponseWrapper> doChangePassword(@PathVariable("newpassword") String newpassword,
			@PathVariable("oldpassword") String oldpassword, @PathVariable("userID") String userID) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			oldpassword = ProtectedConfigFile.encrypt(oldpassword);
			newpassword = ProtectedConfigFile.encrypt(newpassword);

			List<LmsUser> lmsUsers = lmsUserHome.findUserByUserID(Integer.parseInt(userID));

			for (LmsUser lmsUser : lmsUsers) {

				if (lmsUser.getPassword().equals(oldpassword)) {

					lmsUser.setPassword(newpassword);
					lmsUserHome.merge(lmsUser);
					responseWrapper.setMessage("Success. Password changed.");
					return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
				} else {
					responseWrapper.setMessage("Fail. Old Password doesn`t match.");
					return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
				}
			}

			responseWrapper.setMessage("Fail. User not found");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);

		} catch (Exception ex) {

			responseWrapper.setMessage("Fail." + ex.getMessage());
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@RequestMapping(value = "/manageuser/{userName}/{mobile}/{status}/", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> manageuser(@PathVariable("userName") String uName,
			@PathVariable("mobile") String mobile, @PathVariable("status") String status) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		List<LmsUser> lmsUsers = lmsUserHome.findByUnameandMobileList(uName, mobile, status);
		if (lmsUsers.size() > 0) {

			responseWrapper.setListLmsuser(lmsUsers);
			//responseWrapper.setListLmssupervisor(lmsUser);
			//responseWrapper.setLmssupervisor;

			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}
	
	/*	LmsUser lmsUser1 = lmsUserHome.findByUnameandMobile(uName, mobile, status);
		if(lmsUser1!=null) {
			
			//responseWrapper.setLmsuser(lmsUser)
			
			//responseWrapper.setLmsuser(lmsUser1);
			responseWrapper.setLmssupervisor(lmsUser1.getLmsUser());
			
			
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}*/
		 
		responseWrapper.setMessage("Fail. Data not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}

	@RequestMapping(value = "/manageuser/{userid}", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> manageuser(@PathVariable("userid") int uID) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		LmsUser lmsUser = lmsUserHome.findById(uID);
		if (lmsUser != null) {

			responseWrapper.setLmsuser(lmsUser);
			responseWrapper.setLmssupervisor(lmsUser.getLmsUser());

			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}

		responseWrapper.setMessage("Fail. Data not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}

	@RequestMapping(value = "t", method = RequestMethod.POST)
	public void test() {
		System.out.println("Test Methoid");
	}
	
	
	@RequestMapping(value = "/updateuserprofile/{wftroleid}/{roleid}/{lmssupervisorid}/", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> updateuserprofile( @PathVariable("wftroleid") Integer wftroleid, @PathVariable("roleid") Integer roleid,@PathVariable("lmssupervisorid") Integer lmssupervisorid, @RequestBody LmsUser lmsUser){

		ResponseWrapper responseWrapper = new ResponseWrapper();
		LmsRole lmsRole;
		LmsWftRole lmsWftrole;
		LmsUser lmssupervisor;
		
		try {

			lmsRole = lmsRoleHome.findById(roleid);
			lmsWftrole = lmsWftRoleHome.findById(wftroleid);
			lmssupervisor = lmsUserHome.findById(lmssupervisorid);
			

			if (lmsRole != null && lmsWftrole != null) {

				lmsUser.setUpdateDate(new Date());
				lmsUser.setUpdateBy(lmsUser.getId());
				lmsUser.setLmsUser(lmssupervisor);

				lmsUserHome.merge(lmsUser); // For Update

				//manageUserRoleMap(lmsUser, lmsRole);

				//manageWftRoleUserMap(lmsUser, lmsWftrole);

			} else {
				responseWrapper.setMessage("Mentioned Role not found in database.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
			responseWrapper.setMessage("Failed to create User.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

		responseWrapper.setMessage("Success. User has created");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/updateuserprofile/{lmssupervisorid}/", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> updateuserprofile(@PathVariable("lmssupervisorid") Integer lmssupervisorid, @RequestBody UserWrapper userWrapper){

		ResponseWrapper responseWrapper = new ResponseWrapper();
		int[] lmsRoles = userWrapper.getLmsRoles();
		int[] lmsWftroles = userWrapper.getLmsWftRoles();
		LmsUser lmsUser = userWrapper.getLmsuser();
		LmsUser lmssupervisor;
		
		try {

			lmssupervisor = lmsUserHome.findById(lmssupervisorid);
			

			if (lmsUser!=null) {

				lmsUser.setUpdateDate(new Date());
				lmsUser.setUpdateBy(lmsUser.getId());
				lmsUser.setLmsUser(lmssupervisor);

				lmsUserHome.merge(lmsUser); // For Update

				manageUserRoleMap(lmsUser, lmsRoles);

				manageWftRoleUserMap(lmsUser, lmsWftroles);

			} else {
				responseWrapper.setMessage("User not found in database.");
				return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
			responseWrapper.setMessage("Failed to update User profile.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

		responseWrapper.setMessage("User profile has successfully updated.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
	}

	private void manageUserRoleMap(LmsUser lmsUser, int[] lmsRoles) {

		LmsUserRoleMap lmsUserRoleMapInsert;
		LmsRole lmsRole;
		List<LmsUserRoleMap> listlmsUserRoleMap;
		
		boolean found=false;
		
		// Insert / Update User Role Map table
		if (lmsUser != null && lmsRoles != null) {

			listlmsUserRoleMap = lmsUserRoleMapHome.findByUserID(lmsUser.getId());
			
			// Inserting Missing roles into DB			
			for(int roleid:lmsRoles) {
				
				for (LmsUserRoleMap lmsUserRoleMap : listlmsUserRoleMap) {					

					if(roleid == lmsUserRoleMap.getLmsRole().getId()) {
						found= true;
						break;
					}else {
						found= false;
					}
				}
				
				if(!found) {
					
					lmsUserRoleMapInsert = new LmsUserRoleMap();
					
					lmsRole = lmsRoleHome.findById(roleid);
					
					if(lmsRole!=null) {

						lmsUserRoleMapInsert.setLmsRole(lmsRole);
						lmsUserRoleMapInsert.setLmsUser(lmsUser);
						lmsUserRoleMapInsert.setInsertBy(lmsUser.getId());
						lmsUserRoleMapInsert.setInsertDate(new Date());

						lmsUserRoleMapHome.persist(lmsUserRoleMapInsert);
					}
				}		
			}
			

			// Remove/Delete Missing roles into DB			
			for(LmsUserRoleMap lmsUserRoleMap : listlmsUserRoleMap) {
				
				for (int roleid:lmsRoles) {					

					if(roleid == lmsUserRoleMap.getLmsRole().getId()) {
						found= true;
						break;
					}else {
						found= false;
					}
				}
				
				if(!found) {					
					lmsUserRoleMapHome.remove(lmsUserRoleMap);
				}
			}		
		}
	}
	
	private void manageWftRoleUserMap(LmsUser lmsUser, int[] lmsWftroles) {

		List<LmsWftRoleUserMap> listLmsWftRoleUserMap;
		LmsWftRoleUserMap lmsWftRoleUserMapInsert;
		LmsWftRole lmsWftRole;

		boolean found = false;

		// Insert / Update User Role Map table
		if (lmsUser != null && lmsWftroles != null) {

			listLmsWftRoleUserMap = lmsWftRoleUserMapHome.findByUserID(lmsUser.getId());

			// Inserting Missing roles into DB
			for (int wfroleid : lmsWftroles) {

				for (LmsWftRoleUserMap lmsWftRoleUserMap : listLmsWftRoleUserMap) {

					if (wfroleid == lmsWftRoleUserMap.getLmsWftRole().getId()) {
						found = true;
						break;
					} else {
						found = false;
					}
				}

				if (!found) {

					lmsWftRoleUserMapInsert = new LmsWftRoleUserMap();

					lmsWftRole = lmsWftRoleHome.findById(wfroleid);

					if (lmsWftRole != null) {

						lmsWftRoleUserMapInsert.setLmsWftRole(lmsWftRole);
						lmsWftRoleUserMapInsert.setLmsUserByUserId(lmsUser);
						lmsWftRoleUserMapInsert.setInsertBy(lmsUser.getId());
						lmsWftRoleUserMapInsert.setInsertDate(new Date());

						lmsWftRoleUserMapHome.persist(lmsWftRoleUserMapInsert);
					}
				}
			}

			// Remove/Delete Missing roles into DB
			for (LmsWftRoleUserMap lmsWftRoleUserMap : listLmsWftRoleUserMap) {

				for (int wfroleid : lmsWftroles) {

					if (wfroleid == lmsWftRoleUserMap.getLmsWftRole().getId()) {
						found = true;
						break;
					} else {
						found = false;
					}
				}

				if (!found) {
					lmsWftRoleUserMapHome.remove(lmsWftRoleUserMap);
				}
			}
		}
		
		

/*		if (lmsUser != null && lmsWftroles != null) {

			listLmsWftRoleUserMap = lmsWftRoleUserMapHome.findByUserID(lmsUser.getId());

			if (listLmsWftRoleUserMap.size() == 0) {
				lmsWftRoleUserMapInsert = new LmsWftRoleUserMap();

				lmsWftRoleUserMapInsert.setLmsWftRole(lmsWftrole);
				lmsWftRoleUserMapInsert.setLmsUserByUserId(lmsUser);
				lmsWftRoleUserMapInsert.setInsertBy(lmsUser.getId());
				lmsWftRoleUserMapInsert.setInsertDate(new Date());

				lmsWftRoleUserMapHome.persist(lmsWftRoleUserMapInsert);
			}

			for (LmsWftRoleUserMap lmsWftRoleUserMap : listLmsWftRoleUserMap) {

				lmsWftRoleUserMap.setLmsWftRole(lmsWftrole);
				lmsWftRoleUserMap.setUpdateBy(lmsUser.getId());
				lmsWftRoleUserMap.setUpdateDate(new Date());

				lmsWftRoleUserMapHome.merge(lmsWftRoleUserMap);
			}
		}*/
	}

	@RequestMapping(value = "/getUserlist/", method = RequestMethod.GET)
	public ResponseEntity<List<LmsUser>> getlog() {

		List<LmsUser> listLmsUser = new ArrayList<LmsUser>();
		try {
			listLmsUser = lmsUserHome.findAllUser();
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.EXPECTATION_FAILED);
		}
		if (listLmsUser == null) {
			return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.EXPECTATION_FAILED);
		}

		return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.OK);

	}

	@RequestMapping(value = "/updateprofile/{userID}/", method = RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> doupdateprofile(@PathVariable("userID") Integer userID,
			@RequestBody LmsUser lmsUser) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		try {

			LmsUser lmsUsers = lmsUserHome.findById(userID);
			if (lmsUsers != null) {

				lmsUsers.setAddress(lmsUser.getAddress());
				lmsUsers.setEmail(lmsUser.getEmail());
				lmsUsers.setFax(lmsUser.getFax());
				lmsUsers.setPassport(lmsUser.getPassport());
				lmsUsers.setMobilePersonal(lmsUser.getMobilePersonal());
				lmsUsers.setMobileOffice(lmsUser.getMobileOffice());
				lmsUsers.setUpdateDate(new Date());
				lmsUsers.setUpdateBy(lmsUser.getId());
				lmsUserHome.merge(lmsUsers);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			responseWrapper.setMessage("Failed to create User.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
		}

		responseWrapper.setMessage("Success. User has created");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

	}

	@RequestMapping(value = "/manageuserid/{userid}", method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> manageuserid(@PathVariable("userid") int uID) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		LmsUser lmsUser = lmsUserHome.findById(uID);

		if (lmsUser != null) {

			responseWrapper.setLmsuser(lmsUser);

			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
		}

		responseWrapper.setMessage("Fail. Data not matched.");
		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.EXPECTATION_FAILED);
	}
	
	@RequestMapping(value = "/subordinate/{userid}", method = RequestMethod.GET)
	public ResponseEntity<List<LmsUser>> subordinate(@PathVariable("userid") int uID) {
		
	//	LmsUser lmsUser = lmsUserHome.findById(uID);		
		
		List<LmsUser> listLmsUser = new ArrayList<LmsUser>();	
		

		try {
			
			listLmsUser = lmsUserHome.findSupervisorID(uID);			 				
					
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.EXPECTATION_FAILED);
		}
		if (listLmsUser == null) {
			return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.EXPECTATION_FAILED);
		}

		return new ResponseEntity<List<LmsUser>>(listLmsUser, HttpStatus.OK);

	}
	
	
	
	
}
