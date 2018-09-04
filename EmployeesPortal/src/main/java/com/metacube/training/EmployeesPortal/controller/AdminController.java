package com.metacube.training.EmployeesPortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String login() {

		return "/login";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		return "/login";
	}

}
