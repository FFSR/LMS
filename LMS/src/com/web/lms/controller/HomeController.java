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
		
		return " leaveapplication";
	}
}
