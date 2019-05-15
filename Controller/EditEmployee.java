package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Facade.EmployeeFacade;
import Model.EmployeeTransferObject;
import enums.Status;

/**
 * Servlet implementation class EditEmployee
 */
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		Date dob = null;
		try {
			dob = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("dob"));
		} catch (ParseException e) {
			out.println("Date Format Exception");
		}
		String contactNumber = request.getParameter("contactNumber");
		String orgName = request.getParameter("company");

		EmployeeTransferObject emp = new EmployeeTransferObject(fName, lName, email, age, dob, contactNumber, orgName);
		
			if (Status.SUCCESS == employeeFacade.editEmployee(emp)) {
				request.getRequestDispatcher("ShowEmployee").include(request, response);
			} else if(Status.FAIL == employeeFacade.editEmployee(emp)) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("ShowEmployee");
				out.println("<font color=red>Can't update </font>");
				rd.include(request, response);
			}
	}

}
