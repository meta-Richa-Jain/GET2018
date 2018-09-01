package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Employee;
import dao.Helper;
import enums.Status;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Helper h = new Helper();
		if (Status.FOUND == h.checkEmail(email, password)) {
			List<Employee> employeeDetails = h.getEmployeeDetails(email);
			Employee emp = employeeDetails.get(0);
			HttpSession session = request.getSession();
			session.setAttribute("employeeDetails", emp);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("EmployeeProfile");
			requestDispatcher.forward(request, response);
		} else {
			out.println("Invalid Entry");
		}

	}

}
