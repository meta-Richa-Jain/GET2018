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

import Facade.EmployeeFacade;
import enums.Status;
import Model.Employee;

/**
 * Servlet implementation class SignUp
 */

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		Date dob = null;
		try {
			dob = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("dob"));
		} catch (ParseException e) {
			out.println("Date Format Exception");
		}
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String contactNumber = request.getParameter("contactNumber");
		String orgName = request.getParameter("company");

		Employee emp = new Employee(firstName, lastName, email, age, dob, contactNumber, password, orgName);
		if (nameValidation(firstName) && nameValidation(lastName) && emailValidation(email)
				&& numberValidation(contactNumber) && passwordValidation(password)
				&& passwordEquality(password, confirmPassword) && ageValidation(age)) {
			if (Status.SUCCESS == employeeFacade.addEmployee(emp)) {
				HttpSession session = request.getSession();
				session.setAttribute("employeeEmail", emp.getEmail());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmployeeProfile");
				requestDispatcher.forward(request, response);
			} else if(Status.ERROR == employeeFacade.addEmployee(emp)) {
				 RequestDispatcher rd = getServletContext().getRequestDispatcher("SignUp.html");
		         out.println("<font color=red>SQL EXCEPTION</font>");
		         rd.include(request, response);
				
			} else if(Status.FAIL == employeeFacade.addEmployee(emp)) {
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("SignUp.html");
		         out.println("<font color=red>DUPLICATE EMAIL-ID</font>");
		         rd.include(request, response);
				
			}
		}

	}

	public boolean nameValidation(String name) {

		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
		Matcher match = pattern.matcher(name);
		if (match.matches()) {
			return true;

		} else
			return false;
	}

	public boolean emailValidation(String email) {
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher match = pattern.matcher(email);
		if (match.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean numberValidation(String number) {
		Pattern pattern = Pattern.compile("(^[0-9]+$)");
		Matcher match = pattern.matcher(number);
		if (match.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean passwordValidation(String password) {
		Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$");
		Matcher match = pattern.matcher(password);
		if (match.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ageValidation(int age) {
		String ageString = String.valueOf(age);
		Pattern pattern = Pattern.compile("(^[0-9]+$)");
		Matcher match = pattern.matcher(ageString);
		if (match.matches() && age > 18 && age < 70) {
			return true;
		} else {
			return false;
		}
	}

	public boolean passwordEquality(String password, String confirmPassword) {
		if (passwordValidation(confirmPassword) && password == confirmPassword) {
			return true;
		} else {
			return false;
		}
	}

}
