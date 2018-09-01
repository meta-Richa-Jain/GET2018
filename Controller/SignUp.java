package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Helper;
import enums.Status;
import Model.Employee;

/**
 * Servlet implementation class SignUp
 */

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		Date dob = null;
		try {
			dob = new SimpleDateFormat("yyyy-mm-dd").parse(request
					.getParameter("dob"));
		} catch (ParseException e) {
			out.println("Date Format Exception");
		}
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String contactNumber = request.getParameter("contactNumber");
		String orgName = request.getParameter("company");


		Employee emp = new Employee(firstName, lastName, email, age, dob,
				contactNumber, password, orgName);
		Helper h = new Helper();
		if (Status.SUCCESS == h.addEmployee(emp)) {
			HttpSession session = request.getSession();
			session.setAttribute("employeeDetails", emp);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("EmployeeProfile");
			requestDispatcher.forward(request, response);
		}
	}

	

}
