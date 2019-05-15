package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.HelperFunction;
import com.POJO.Employee;

public class ChangedEmployeeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Employee emp = new Employee(fName, lName, email, age);
		HelperFunction func = new HelperFunction();
		try {
			func.UpdateEmployeeDetails(emp);
			request.getRequestDispatcher("ShowEmployee").include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
