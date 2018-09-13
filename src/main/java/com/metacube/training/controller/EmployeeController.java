package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeDTO;
import com.metacube.training.model.Login;
import com.metacube.training.model.User;
import com.metacube.training.service.AdminServiceImpl;
import com.metacube.training.service.EmailService;
import com.metacube.training.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@Autowired
	private AdminServiceImpl adminService;

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("login", new Login());
		return "employee/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, Model model) {
		int empCode = Integer.parseInt(username);
		Login login = employeeService.checkLoginDetails(empCode);
		if (login.getEmpCode() == empCode && login.getPassword().equals(password)) {
			return new ModelAndView("employee/dashboard", "empCode", empCode);
		} else {
			model.addAttribute("error", "invalid username or password");
			return new ModelAndView("employee/login");
		}
	}

	@RequestMapping(value = "/showProfile", method = RequestMethod.GET)
	public String Project(@RequestParam("code") int code, Model model) {
		model.addAttribute("employee", employeeService.showProfile(code));
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

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public String updatePassword(@RequestParam("email") String email) {
		EmployeeDTO employee = employeeService.getEmployeeByEmail(email);
		User user = new User();

		user.setEmailId(employee.getEmailId());
		user.setFirstName(employee.getFirstName());
		user.setLastName(employee.getLastName());
		user.setPassword("BLABLA");
		emailService.sendEmail(user);

		return "employee/dashboard";
	}

}
