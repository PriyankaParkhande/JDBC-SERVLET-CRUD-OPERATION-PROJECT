package org.productApp;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class admin
 */
@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        RequestDispatcher r=request.getRequestDispatcher("navbar.html");   
          r.forward(request,response);    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("name");
		String password=request.getParameter("pass");
		
		if(username.equals("admin") && password.equals("admin")) {
			RequestDispatcher r=request.getRequestDispatcher("navbar.html");
			r.forward(request, response);
		}
		else {
		RequestDispatcher r=request.getRequestDispatcher("admin.html");
		r.include(request, response);
			out.println("<h4>Invalid username and password</h4>");
	}

}
}
