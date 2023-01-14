package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.productApp.ProductDataAdd;
import org.services.ProductService;

@WebServlet("/update")
public class FinalUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String pname = request.getParameter("pname");
		String cname = request.getParameter("cname");
		int pprice=Integer.parseInt(request.getParameter("pprice"));
		int pid = Integer.parseInt(request.getParameter("pid"));		
		ProductDataAdd p=new ProductDataAdd();
		p.setPid(pid);
		p.setPname(pname);
		p.setPprice(pprice);
		p.setCname(cname);
		ProductService ps=new ProductService();
		boolean b=ps.isFinalUpdate(p);
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("ViewData");
			r.forward(request, response);
		}else {
			System.out.println("<h1>some problem is their</h1>");

		}
	}  

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
 