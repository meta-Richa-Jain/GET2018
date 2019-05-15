package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadImage
 */


public class UploadImage extends HttpServlet {
	
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filename = request.getParameter("upload");
		String filepath = "C:/Users/user/eclipse-workspace/EAD-Assignment4/WebContent/";
		PrintWriter out = response.getWriter();
		out.println(filename);
		System.out.println(filename);
		request.getRequestDispatcher("EmployeeProfile").include(request, response);
		//Part filePart = request.getPart("upload");
	}

}
