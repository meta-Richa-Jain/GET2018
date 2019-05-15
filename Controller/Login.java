package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facade.EmployeeFacade;
import enums.Status;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (Status.FOUND == employeeFacade.checkLoginDetails(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("employeeEmail", email);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmployeeProfile");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("Login.html");
			out.println("<font color=red>Invalid Email or Password</font>");
			rd.include(request, response);
		}

	}

}
