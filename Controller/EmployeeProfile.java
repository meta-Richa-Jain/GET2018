package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Employee;

/**
 * Servlet implementation class EmployeeProfile
 */

public class EmployeeProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		Employee emp = (Employee) session.getAttribute("employeeDetails");

		try {
		

		response.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Update</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table width= 80%><tr><td align='right'><img src= 'Images/default.jpg' height='85'></td>"
				+ "<td><input type = 'file' name = 'upload' value ='Upload' /></td><td> "
				+ emp.getFirstName()
				+ " "
				+ emp.getLastName()
				+ "| <a href = 'Home.html'>"
				+ " Logout "
				+ " </a></td></tr></table>");
		out.println("<hr width='90%'>");
		out.println("<h1 align='center'>User Profile</h1>");
		out.println("<form action='EmployeeProfile' method='get'>");
		out.println("<table align='left' cellspacing='30px' >");


		out.println("<tr><td>First Name</td>");
		out.println("<td>" + emp.getFirstName()+ "</td></tr>");
		out.println("<tr><td>Last Name</td>");
		out.println("<td>" +emp.getLastName() + "</td></tr>");
		out.println("<tr><td>DateOfBirth</td>");
		out.println("<td>" +emp.getDob() + "</td></tr>");
		out.println("<tr><td>Contact</td>");
		out.println("<td>" +emp.getContactNumber() + "</td></tr>");
		out.println("<tr><td>Email</td>");
		out.println("<td>" + emp.getEmail()+ "</td><br></tr>");
		out.println("<tr><td>Organization</td>");
		out.println("<td>" + emp.getOrgName()+ "</td></tr>");
		out.println("<tr><td><input type='submit' value='Edit'/></td></tr>");
		out.println("</table>");
		out.println("</form><br />");
		out.println("<FORM action = 'Home.html' id = 'friends' name = 'friends' ><table> <tr>");
		out.println("<td><input type = 'submit' value = 'Friends' /></td></tr></table></form>");


		out.println("</body>");
		out.println("</html>");
		} catch(Exception e){
			out.println("Invalid");
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		Employee emp = (Employee) session.getAttribute("employeeDetails");

		out.println("<!DOCTYPE html>");
		out.println("<HTML> <BODY>");
		out.println("<table width= 80%><tr><td align='right'><img src= 'Images/default.jpg' height='85'></td>"
				+ "<td><input type = 'file' name = 'upload' value ='Upload' /></td><td> "
				+ emp.getFirstName()
				+ " "
				+ emp.getLastName()
				+ "| <a href = 'Home.html'>"
				+ " Logout "
				+ " </a></td></tr></table>");
		out.println("<hr width='90%'>");
		out.println("<TABLE width= '60%' align = 'center'>");
		out.println("<TR>");
		out.println("<TD>" + "First Name" + "</TD>");
		out.println("<TD><input type = 'text' name = 'fName' value = '"
				+ emp.getFirstName() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Last Name" + "</TD>");
		out.println("<TD><input type = 'text' name = 'fName' value = '"
				+ emp.getLastName() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Email" + "</TD>");
		out.println("<TD><input type = 'text' name = 'fName' value = '"
				+ emp.getEmail() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Age" + "</TD>");
		out.println("<TD><input type = 'text' name = 'fName' value = '"
				+ emp.getAge() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "DoB" + "</TD>");
		out.println("<TD><input type = 'text' name = 'fName' value = '"
				+ emp.getDob() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Contact Number: " + "</TD>");
		out.println("<TD><input type = 'text' name = 'fName' value = '"
				+ emp.getContactNumber() + "'/></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>" + "Organization Name: " + "</TD>");
		out.println("<td><select id='company' name='company'>"
				+ "<option value='metacube'>Metacube</option>"
				+ "<option value='mindtree'>Mindtree</option>"
				+ "<option value='infosys'>Infosys</option>"
				+ "<option value='ibm'>Accenture</option> " + "</select></td>");
		out.println("</TR>");
		out.println("<TR colspan ='2'>");
		out.println("<TD><input type = 'button' value = 'edit' name = 'edit' /></TD>");
		out.println("</TR>");
		out.println("</TABLE></BODY></HTML>");

		out.close();
	}

}
