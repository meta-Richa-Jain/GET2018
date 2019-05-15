package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.HelperFunction;
import com.POJO.Employee;

/**
 * Servlet implementation class SearchEmployee
 */

public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HelperFunction func = new HelperFunction();
		PrintWriter out = response.getWriter();
		String name = request.getParameter("searchByName");
		
		try{
			List<Employee> employeeDetails = func.searchEmployee(name);
			out.println("<HTML> <BODY>");
			out.println("<TABLE border = '1' width = '40px'>");
			out.println("<TR>");
			out.println("<TH>" + "First Name" + "</TH>");
			out.println("<TH>" + "Last Name" + "</TH>");
			out.println("<TH>" + "Email" + "</TH>");
			out.println("<TH>" + "Age" + "</TH>");
			out.println("</TR>");
			for (Employee emp : employeeDetails) {
				out.print("<TR>");
				out.print("<TD>" + emp.getFirstName() + "</TD>");
				out.print("<TD>" + emp.getLastName() + "</TD>");
				out.print("<TD>" + emp.getEmail() + "</TD>");
				out.print("<TD>" + emp.getAge() + "</TD>");
				out.print("</TR>");
			}
			out.println("</TABLE>");
			out.println("</BODY> </HTML>");
		} catch (SQLException e) {
			out.println(e);
		}
	}

}
