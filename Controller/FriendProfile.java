package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facade.EmployeeFacade;
import Model.EmployeeTransferObject;

/**
 * Servlet implementation class FriendProfile
 */

public class FriendProfile extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String email = (String)session.getAttribute("employeeEmail");
		List<EmployeeTransferObject> employeeDetails = employeeFacade.getEmployeeDetails(email);
		EmployeeTransferObject emp = employeeDetails.get(0);

		try {
			List<EmployeeTransferObject> friendDetails = employeeFacade.getEmployeeDetails(request.getParameter("email"));
			EmployeeTransferObject friend = friendDetails.get(0);
			response.setContentType("text/html");
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Profile</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action = 'UploadImage' method = 'post' enctype = 'multipart/form-data' >");
			out.println("<table width= 80% align = 'center'><tr colspan =2><td align='left'><img src= '"
					+ emp.getImage_url() + "'  height='65'></td></tr>"
					+ "<tr><td><input type = 'file' name = 'upload' value ='Upload' /></td><td align = 'right'> "
					+ "Welcome " + emp.getFirstName() + " " + emp.getLastName() + " | </td></tr></table></form>"
					+ "<FORM action = 'LogOutServlet' method = 'post' ><Table><tr><td><a href = 'Home.html'>"
					+ " Logout " + " </a></td></tr></table></form>");
			out.println("<hr width='90%'>");
			out.println("<h1 align='center'>Profile</h1>");
			out.println("<table align='center' cellspacing='30px' >");

			out.println("<tr><td>First Name</td>");
			out.println("<td>" + friend.getFirstName() + "</td></tr>");
			out.println("<tr><td>Last Name</td>");
			out.println("<td>" + friend.getLastName() + "</td></tr>");
			out.println("<tr><td>DateOfBirth</td>");
			out.println("<td>" + friend.getDob() + "</td></tr>");
			out.println("<tr><td>Contact</td>");
			out.println("<td>" + friend.getContactNumber() + "</td></tr>");
			out.println("<tr><td>Email</td>");
			out.println("<td>" + friend.getEmail() + "</td><br></tr>");
			out.println("<tr><td>Organization</td>");
			out.println("<td>" + friend.getOrgName() + "</td></tr>");
			out.println("</table>");
			out.println("<br />");

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			out.println("Invalid");
		}

	}

}
