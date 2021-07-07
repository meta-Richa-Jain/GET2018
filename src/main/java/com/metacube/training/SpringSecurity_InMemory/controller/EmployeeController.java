package com.metacube.training.SpringSecurity_InMemory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.SpringSecurity_InMemory.model.Employee;
import com.metacube.training.SpringSecurity_InMemory.service.EmployeeServiceImpl;



@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	

	@RequestMapping(value = "/showProfile", method = RequestMethod.GET)
	public String Project(@RequestParam("code") int code, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeByCode(code));
		return "employee/showProfile";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "employee/login";
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword() {
		return "employee/resetPassword";
	}

}
