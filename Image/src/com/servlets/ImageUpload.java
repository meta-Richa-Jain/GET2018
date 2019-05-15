package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageUpload
 */
@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			HelperFunction h = new HelperFunction();
			String filepath = h.getPath(1);
			// out.println(h.getPath(1));

			response.setContentType("text/html");
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Profile</title>");
			out.println("</head><body>");
			out.println("<form action = 'UploadImage' enctype = 'multipart/form-data' >");
			out.println("<table><tr><td>");
			out.println("<img src = '" + filepath + "' name = 'image_path' ></td></tr>");
			out.println("<tr><td><input type = 'file' name = 'upload' value ='Upload' /></td></tr>");
			out.println("<tr><td><input type = 'submit' name = 'submit' value = 'upload' /></td></tr>");
			out.println("</table></form>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			out.println("Invalid");
		}
	}

}
