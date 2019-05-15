package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.ConnectionPool;
import com.Database.HelperFunction;
import com.Database.Queries;
import com.POJO.Employee;

@SuppressWarnings("serial")
public class AddEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));

		PrintWriter out = response.getWriter();


		Employee emp = new Employee(firstName, lastName, email, age);
		try {
			HelperFunction func = new HelperFunction();
			func.addEmployee(emp);
		} catch (SQLException e) {
			out.println(e);
		}

	}

}
