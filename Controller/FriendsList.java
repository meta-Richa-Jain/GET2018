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
import Model.Friend;

/**
 * Servlet implementation class FriendsList
 */

public class FriendsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String email = (String)session.getAttribute("employeeEmail");
		List<EmployeeTransferObject> employeeDetails = employeeFacade.getEmployeeDetails(email);
		EmployeeTransferObject emp = employeeDetails.get(0);
		try {

			List<Friend> friendsList = employeeFacade.getFriendsList(emp.getOrgName(), emp.getFirstName(),
					emp.getLastName());
			response.setContentType("text/html");
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Friends</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action = 'UploadImage' method = 'post' enctype = 'multipart/form-data' >");
			out.println("<table width= 80% align = 'center'><tr colspan =2><td align='left'><img src= '"
					+ emp.getImage_url() + "' height='65'></td></tr>"
					+ "<tr><td><input type = 'file' name = 'upload' value ='Upload' /></td><td align = 'right'> "
					+ "Welcome " + emp.getFirstName() + " " + emp.getLastName() + " | </td></tr></table></form>"
					+ "<FORM action = 'LogOutServlet' method = 'post' ><Table><tr><td><a href = 'Home.html'>"
					+ " Logout " + " </a></td></tr></table></form>");
			out.println("<hr width='90%'>");
			out.println("<h1 align='center'>Friends</h1>");
			out.println("<table align='center' cellspacing='30px' >");

			out.println("<tr><th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Email</th></tr>");
			for (Friend friend : friendsList) {
				out.print("<TR>");
				out.print("<TD>" + friend.getFirstName() + "</TD>");
				out.print("<TD>" + friend.getLastName() + "</TD>");
				out.print("<TD>" + friend.getEmail() + "</TD>");
				out.print("<TD><a href='FriendProfile?email=" + friend.getEmail() + "'>View</a></td>");
				out.print("</TR>");
			}
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			out.println("Invalid");
		}
	}

}
