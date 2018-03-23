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
}
