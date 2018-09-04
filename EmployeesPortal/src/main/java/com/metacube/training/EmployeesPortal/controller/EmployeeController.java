package com.metacube.training.EmployeesPortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

  
    
 
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView getEmployee() {
        
        return new ModelAndView("home","message","Get Method");
    
    }
    
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ModelAndView saveEmployee() {
        
    	return new ModelAndView("home","message","Post Method");
    }
 
    }
