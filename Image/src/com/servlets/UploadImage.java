package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet("/UploadImage")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filepath = request.getParameter("upload");
		PrintWriter out = response.getWriter();
		HelperFunction h = new HelperFunction();
		h.upload(1,filepath);
		try {
			request.getRequestDispatcher("Index.html").include(request, response);
		} catch(Exception e) {
			out.println("ERROR");
		}
	}

}
