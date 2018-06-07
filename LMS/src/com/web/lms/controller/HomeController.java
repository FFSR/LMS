package com.web.lms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping("/")
	public String root(Model model) {
		
		// httpSession.invalidate();
		//String n = httpSession.getAttribute("userName").toString();
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "index";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	

	@RequestMapping("/registration")
	public String registration(Model model) {
		
		/*try {
			if("" != httpSession.getAttribute("userName").toString()) {*/
				return "registration";
			/*}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}*/
	}
	
	@RequestMapping("/leaveapplication")
	public String  leaveapplication(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "leaveapplication";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
		
	}

	@RequestMapping("/login")
	public String login(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "login";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/changepassword")
	public String changepassword(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "changepassword";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/adminpanel")
	public String adminpanel(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "adminpanel";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/leavehistory")
	public String leavehistory(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "leavehistory";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/manageuser")
	public String manageuser(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "manageuser";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/manageusersearch")
	public String manageusersearch(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "manageusersearch";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/userprofile")
	public String userprofile(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "userprofile";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/updateprofile")
	public String updateprofile(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "updateprofile";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/leavehistorysearch")
	public String leavehistorysearch(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "leavehistorysearch";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/leavehistoryresult")
	public String leavehistoryresult(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "leavehistoryresult";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/forgetpasswd")
	public String forgetpasswd(Model model) {
		
	/*	try {
			if("" != httpSession.getAttribute("userName").toString()) { */
				return "forgetpasswd";
		/*	}else {
			
				return "login";
			/* } 
	/*	}catch(Exception ex) {
			return "login";
		}*/
	}
	
	@RequestMapping("/employeehomepage")
	public String employeehomepage(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "employeehomepage";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
		
	}
	@RequestMapping("/leavemanagementhead")
	public String leavemanagementhead(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "leavemanagementhead";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	@RequestMapping("/managereliever")
	public String managereliever(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "managereliever";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	@RequestMapping("/delegateemployee")
	public String delegateemployee(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "delegateemployee";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/leaveapplicationdetails")
	public String leaveapplicationdetails(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "leaveapplicationdetails";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	@RequestMapping("/holidaymanagement")
	public String holidaymanagement(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "holidaymanagement";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	@RequestMapping("/rptleavestatus")
	public String rptleavestatus(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "rptleavestatus";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/leavesearchresult")
	public String leavesearchresult(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "leavesearchresult";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	@RequestMapping("/ministryinfo")
	public String ministryinfo(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "ministryinfo";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	
	
	@RequestMapping("/subordinatelvblnce")
	public String subordinatelvblnce(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "subordinatelvblnce";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}	
	
	
	@RequestMapping("/applicationforleave")
	public String applicationforleave(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "applicationforleave";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	@RequestMapping("/leave")
	public String leave(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "leave";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	@RequestMapping("/testleave")
	public String testleave(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "testleave";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/divisioninfo")
	public String divisioninfo(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "divisioninfo";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
		
	@RequestMapping("/logout")
	public String logout(Model model) {
		
		httpSession.invalidate();
		
		return "login";
	}
	
	@RequestMapping("/unauthorised")
	public String unauthorised(Model model) {
		
		try {
			if("" != httpSession.getAttribute("userName").toString()) {
				return "unauthorised";
			}else {
			
				return "login";
			}
		}catch(Exception ex) {
			return "login";
		}
	}
	
	@RequestMapping("/requestDetails")
	public String requestDetails(Model model, @RequestParam(value="wfID", required=true) Integer wfID, @RequestParam(value="leaveApplication", required=true) Integer leaveApplication) {
		
		//httpSession.invalidate();
		model.addAttribute("wfID", wfID);
		model.addAttribute("leaveApplication", leaveApplication);
		return "requestDetails";
	}
	
}
