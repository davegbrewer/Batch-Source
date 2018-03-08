package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(password.equals("admin123")) {
//			pw.println("Welcome, "+username);
//			pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("problem", null);	//should this be password and password?
			resp.sendRedirect("profile");
		} else {
//			pw.println("Lol no");
//			pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}
		
	}

}




