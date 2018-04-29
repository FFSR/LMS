package com.web.lms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

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
		
		return "registration";
	}
	
	@RequestMapping("/leaveapplication")
	public String  leaveapplication(Model model) {
		
		return "leaveapplication";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		
		return "login";
	}
	
	@RequestMapping("/changepassword")
	public String changepassword(Model model) {
		
		return "changepassword";
	}
	
	@RequestMapping("/adminpanel")
	public String adminpanel(Model model) {
		
		return "adminpanel";
	}
	
	@RequestMapping("/leavehistory")
	public String leavehistory(Model model) {
		
		return "leavehistory";
	}
	
	@RequestMapping("/manageuser")
	public String manageuser(Model model) {
		
		return "manageuser";
	}
	
	@RequestMapping("/manageusersearch")
	public String manageusersearch(Model model) {
		
		return "manageusersearch";
	}
	
	@RequestMapping("/userprofile")
	public String userprofile(Model model) {
		
		return "userprofile";
	}
	
	@RequestMapping("/leavehistorysearch")
	public String leavehistorysearch(Model model) {
		
		return "leavehistorysearch";
	}
	
	@RequestMapping("/leavehistoryresult")
	public String leavehistoryresult(Model model) {
		
		return "leavehistoryresult";
	}
	
	@RequestMapping("/forgetpasswd")
	public String forgetpasswd(Model model) {
		
		return "forgetpasswd";
	}
	
	@RequestMapping("/employeehomepage")
	public String employeehomepage(Model model) {
		
		return "employeehomepage";
	}
	@RequestMapping("/leavemanagementhead")
	public String leavemanagementhead(Model model) {
		
		return "leavemanagementhead";
	}
	@RequestMapping("/leaveapplicationdetails")
	public String leaveapplicationdetails(Model model) {
		
		return "leaveapplicationdetails";
	}
	@RequestMapping("/holidaymanagement")
	public String holidaymanagement(Model model) {
		
		return "holidaymanagement";
	}
	@RequestMapping("/rptleavestatus")
	public String rptleavestatus(Model model) {
		
		return "rptleavestatus";
	}
	
	@RequestMapping("/leavesearchresult")
	public String leavesearchresult(Model model) {
		
		return "leavesearchresult";
	}
	@RequestMapping("/ministryinfo")
	public String ministryinfo(Model model) {
		
		return "ministryinfo";
	}
	@RequestMapping("/applicationforleave")
	public String applicationforleave(Model model) {
		
		return "applicationforleave";
	}
	@RequestMapping("/leave")
	public String leave(Model model) {
		
		return "leave";
	}
	@RequestMapping("/testleave")
	public String testleave(Model model) {
		
		return "testleave";
	}
	@RequestMapping("/divisioninfo")
	public String divisioninfo(Model model) {
		
		return "divisioninfo";
	}
	
	@RequestMapping("/menu")
	public String menu(Model model) {
		
		return "menu";
	}
	
}
