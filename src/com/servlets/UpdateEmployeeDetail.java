package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmployeeDetail
 */

public class UpdateEmployeeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String oldFirstName = request.getParameter("fname");
		String oldLastName = request.getParameter("lname");
		String oldEmail = request.getParameter("email");
		int oldAge = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter();
		out.println("<HTML> <BODY><FORM action = 'ChangedEmployeeDetail' id = 'updateForm' name = 'updateForm'>");
		out.println("<TABLE width = '40px'>");
		out.println("<TR>");
		out.println("<TD>" + "First Name" + "</TD>");
		out.println("<TD> <input type = 'text' name = 'fName' value = '" + oldFirstName + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Last Name" + "</TD>");
		out.println("<TD> <input type = 'text' name = 'lName' value = '" + oldLastName + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Email" + "</TD>");
		out.println("<TD><input type = 'hidden' name = 'email' value = '" + oldEmail + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Age" + "</TD>");
		out.println("<TD><input type = 'text' name = 'age' value = '" + oldAge +  "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD> <input type = 'submit' value = 'submit' id = 'submit' /> </TD>");
		out.println("</TR>");
		out.println("</TABLE> </FORM>");
		out.println("</BODY> </HTML>");
		
		
		
		
	}

}
