package com.metacube.training.EAD_EmployeePortal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/error" , method = RequestMethod.GET)
	public String errorPage(){
		return "error";
	}
	
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String afterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin/security";
		}else if(request.isUserInRole("ROLE_USER")){
			return "redirect:/employee/security";
		}
		return "redirect:/error";
	}


	

}