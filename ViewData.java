package org.controller;

import org.productApp.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.productApp.ProductDataAdd;
import org.services.ProductService;


@WebServlet("/ViewData")
public class ViewData extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		out.println("<br><br>");
		ProductService pService = new ProductService();
		List<ProductDataAdd> list = pService.getAllProducts();
		out.println("<center>");

		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Product Name</th><th>Company Name</th><th>Product Price</th><th>Delete</th><th>Update</th>");
		out.println("</tr>");
		for (ProductDataAdd p : list) {
			int prodid=p.getPid();
			out.println("<tr>");
			out.println("<td align='center'>" + p.getPname() + "</td>");
			out.println("<td align='center'>" + p.getCname() + "</td>");
			out.println("<td align='center'>" + p.getPprice() + "</td>");
			out.println("<td align='center'><a href='deleteData?pid="+prodid+"'>Delete</a></td>");
			out.println("<td align='center'><a href='UpdateData?pname="+p.getPname()+"&cname="+p.getCname()+"&pprice="+p.getPprice()+"&pid="+p.getPid()+"'>Update</a></td>");
			out.println("</tr>");

		}

		out.println("</table>");
		out.println("</center>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
