package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class SignUpFilter
 */

public class SignUpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (validateAll(request)) {
			chain.doFilter(request, response);
		} else{
			PrintWriter out = response.getWriter();
			out.println("INVALID ENTRY");
			request.getRequestDispatcher("SignUp.html").include(request, response);
			
		}

	}

	public boolean validateAll(ServletRequest request) {
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		Date dob = null;
		try {
			dob = new SimpleDateFormat("yyyy-mm-dd").parse(request
					.getParameter("dob"));
		} catch (ParseException e) {

		}
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String contactNumber = request.getParameter("contactNumber");
		String orgName = request.getParameter("company");
		if (nameValidation(firstName) && nameValidation(lastName)
				) {
			return true;
		} else {
			return false;
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
		Pattern pattern = Pattern.compile(
				"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
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
		Pattern pattern = Pattern
				.compile("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$");
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

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
