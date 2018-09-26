package com.metacube.training.EAD_EmployeePortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EAD_EmployeePortal.services.AdminServiceImpl;
import com.metacube.training.EAD_EmployeePortal.services.ProjectServiceImpl;
import com.metacube.training.EAD_EmployeePortal.models.Employee;
import com.metacube.training.EAD_EmployeePortal.models.Job;
import com.metacube.training.EAD_EmployeePortal.models.Project;
import com.metacube.training.EAD_EmployeePortal.models.Skill;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectServiceImpl projectService;

	@Autowired
	private AdminServiceImpl adminService;

//	@GetMapping("/login")
//	public String login() {
//		return "admin/login";
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
//		if ("admin".equals(username) && "admin".equals(password)) {
//			return new ModelAndView("admin/dashboard", "username", username);
//		} else {
//			return new ModelAndView("admin/login");
//		}
//	}
	
	@RequestMapping(value = "/security", method = RequestMethod.GET)
	public String loginSecurity() {
		return "admin/dashboard";
	}

	@RequestMapping(path = "saveproject", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if (project != null) {
			projectService.addProject(project);
		} else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String Project(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public String addProject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/addProject";
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public ModelAndView addProject(@ModelAttribute("project") Project project) {
		if (project != null && project.getId() == 0) {
			projectService.addProject(project);
		}
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "admin/addEmployee";
	}

	@RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee) {
		if (employee != null && employee.getCode() == 0) {
			adminService.addEmployee(employee);
		}
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/addJob", method = RequestMethod.GET)
	public String addJob(Model model) {
		model.addAttribute("job", new Job());
		return "admin/addJob";
	}

	@RequestMapping(path = "/addJob", method = RequestMethod.POST)
	public ModelAndView addJob(@ModelAttribute("job") Job job) {
		if (job != null) {
			adminService.addJob(job);
		}
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/addSkill", method = RequestMethod.GET)
	public String addSkill(Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/addSkill";
	}

	@RequestMapping(path = "/addSkill", method = RequestMethod.POST)
	public ModelAndView addSkill(@ModelAttribute("skill") Skill skill) {

		if (skill != null) {
			adminService.addSkills(skill);
		}
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee() {
		return "admin/searchEmployee";
	}

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public String searchEmployee(@RequestParam("value") String value, @RequestParam("searchBy") String searchBy,
			Model model) {
		List<Employee> listOfEmployees = adminService.searchEmployee(searchBy, value);
		if (listOfEmployees != null) {
			model.addAttribute("employees", listOfEmployees);
			return "admin/showEmployee";
		}
		return "admin/dashboard";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "admin/login";
	}

}
