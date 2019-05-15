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
 * Servlet implementation class EmployeeProfile
 */

public class EmployeeProfile extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("employeeEmail");
		List<EmployeeTransferObject> employeeDetails = employeeFacade.getEmployeeDetails(email);
		EmployeeTransferObject emp = employeeDetails.get(0);

		try {

			response.setContentType("text/html");
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Profile</title>");
			out.println("</head><body>");
			out.println("<form action = 'UploadImage' method = 'post' enctype = 'multipart/form-data' >");
			out.println("<table width= 80% align = 'center'><tr colspan =2><td align='left'><img src= '"
					+ emp.getImage_url() + "' height='65'></td></tr>"
					+ "<tr><td><input type = 'file' name = 'upload' value ='Upload' /></td><td align = 'right'> "
					+ "Welcome " + emp.getFirstName() + " " + emp.getLastName() + " | </td></tr></table></form>"
					+ "<FORM action = 'LogOutServlet' method = 'post' ><Table><tr><td><a href = 'Home.html'>"
					+ " Logout " + " </a></td></tr></table></form>");
			out.println("<hr width='90%'>");
			out.println("<h1 align='center'>Profile</h1>");
			out.println("<form action='EmployeeProfile' method='get'>");
			out.println("<table align='center' cellspacing='30px' >");

			out.println("<tr><td>First Name</td>");
			out.println("<td>" + emp.getFirstName() + "</td></tr>");
			out.println("<tr><td>Last Name</td>");
			out.println("<td>" + emp.getLastName() + "</td></tr>");
			out.println("<tr><td>DateOfBirth</td>");
			out.println("<td>" + emp.getDob() + "</td></tr>");
			out.println("<tr><td>Contact</td>");
			out.println("<td>" + emp.getContactNumber() + "</td></tr>");
			out.println("<tr><td>Email</td>");
			out.println("<td>" + emp.getEmail() + "</td><br></tr>");
			out.println("<tr><td>Organization</td>");
			out.println("<td>" + emp.getOrgName() + "</td></tr>");
			out.println("<tr><td><input type='submit' value='Edit'/></td></tr>");
			out.println("</table>");
			out.println("</form><br />");
			out.println("<FORM action = 'FriendsList' id = 'friends' name = 'friends' method = 'post'><table> <tr>");
			out.println("<td><input type = 'submit' value = 'My Friends List' /></td></tr></table></form>");

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			out.println("Invalid");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("employeeEmail");
		List<EmployeeTransferObject> employeeDetails = employeeFacade.getEmployeeDetails(email);
		EmployeeTransferObject emp = employeeDetails.get(0);

		out.println("<!DOCTYPE html>");
		out.println("<HTML> <BODY>");
		out.println("<form action = 'UploadImage' method = 'post' enctype = 'multipart/form-data' >");
		out.println("<table width= 80% align = 'center'><tr colspan =2><td align='left'><img src= '"
				+ emp.getImage_url() + "'  height='65'></td></tr>"
				+ "<tr><td><input type = 'file' name = 'upload' value ='Upload' /></td><td align = 'right'> "
				+ "Welcome " + emp.getFirstName() + " " + emp.getLastName() + " | </td></tr></table></form>"
				+ "<FORM action = 'LogOutServlet' method = 'post' ><Table><tr><td><a href = 'Home.html'>" + " Logout "
				+ " </a></td></tr></table></form>");
		out.println("<hr width='90%'>");
		out.println(
				"<FORM action = 'EditEmployee' id = 'editEmployee' name = 'editEmployee' ><TABLE width= '60%' align = 'center'>");
		out.println("<TR>");
		out.println("<TD>" + "First Name" + "</TD>");
		out.println("<TD><input type = 'text' name = 'fName' value = '" + emp.getFirstName() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Last Name" + "</TD>");
		out.println("<TD><input type = 'text' name = 'lName' value = '" + emp.getLastName() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Email" + "</TD>");
		out.println("<TD><input type = 'text' name = 'email' value = '" + emp.getEmail() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Age" + "</TD>");
		out.println("<TD><input type = 'text' name = 'age' value = '" + emp.getAge() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "DoB" + "</TD>");
		out.println("<TD><input type = 'text' name = 'dob' value = '" + emp.getDob() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Contact Number: " + "</TD>");
		out.println("<TD><input type = 'text' name = 'contact' value = '" + emp.getContactNumber() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Organization Name: " + "</TD>");
		out.println("<td><select id='company' name='company'>" + "<option value='metacube'>Metacube</option>"
				+ "<option value='mindtree'>Mindtree</option>" + "<option value='infosys'>Infosys</option>"
				+ "<option value='ibm'>Accenture</option> " + "</select></td>");
		out.println("</TR>");
		out.println("<TR colspan ='2'>");
		out.println("<TD><input type = 'submit' value = 'edit' name = 'edit' /></TD>");
		out.println("</TR>");
		out.println("</TABLE></BODY></HTML>");

		out.close();
	}

}
