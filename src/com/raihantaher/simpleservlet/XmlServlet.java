package com.raihantaher.simpleservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(description = "This is XML Servlet", urlPatterns = {"/XmlServletPath"})
public class XmlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		
		HttpSession session = request.getSession();
		
		if(userName != "" && userName != null)
		{
			session.setAttribute("username_session", userName);
		}
		
		PrintWriter writer = response.getWriter();
		
		writer.println("Get Hello " + userName + "!" + " Session name " + session.getAttribute("username_session"));
		
		System.out.println("Hello XML Servlet");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");

		String fullName = request.getParameter("fullName");
		String prof = request.getParameter("prof");
//		String location = request.getParameter("location");
		
		String[] locations = request.getParameterValues("location");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("Post Hello " + userName + "! fullname: " + fullName + " prof " + prof + " location " + locations.length);
		for(int i=0;i<locations.length;i++) {
			writer.println("location is " + locations[i]);
		}
		System.out.println("This is a POST method");
	}
}
