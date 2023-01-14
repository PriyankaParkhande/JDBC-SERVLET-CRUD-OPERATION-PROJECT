package org.controller;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.services.ProductService;

@WebServlet("/deleteData")
public class deleteData extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int prodid = Integer.parseInt(request.getParameter("pid"));//accept data using its name
		ProductService ps=new ProductService();
		boolean b=ps.isDeleteProduct(prodid);
		
		if(b) {
			out.println("<h1>Product  Deleted</h1>");
		}
		else{
			
			RequestDispatcher r=request.getRequestDispatcher("ViewData");
			r.forward(request, response);
		
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doGet(request, response);
	}

}
