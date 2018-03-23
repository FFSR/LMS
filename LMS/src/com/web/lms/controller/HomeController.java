package com.web.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String root(Model model) {
		
		return "index";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model) {
		
		return "registration";
	}
	
	@RequestMapping("/leaveapplication")
	public String  leaveapplication(Model model) {
		
		return "leaveapplication";
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
	@RequestMapping("/leavemanagementdetails")
	public String leavemanagementdetails(Model model) {
		
		return "leavemanagementdetails";
	}
	@RequestMapping("/holidaymanagement")
	public String holidaymanagement(Model model) {
		
		return "holidaymanagement";
	}
	@RequestMapping("/rptleavestatus")
	public String rptleavestatus(Model model) {
		
		return "rptleavestatus";
	}
	
	
	
}
