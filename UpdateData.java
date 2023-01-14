package org.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String pname = request.getParameter("pname");
		String cname = request.getParameter("cname");
		int pprice=Integer.parseInt(request.getParameter("pprice").trim());
		int pid = Integer.parseInt(request.getParameter("pid").trim());		

				out.println("<html>");
		out.println("<head><title>Update Product</title><link rel=\"icon\" href=\"https://www.bbassets.com/static/v2619/images/favicon.ico?v=2619\"  type=\"image/x-icon\"></link></head>");
		out.println("<body>");
			RequestDispatcher r = request.getRequestDispatcher("navbar.html");
	r.include(request, response);
	out.println("<br><br>");
	out.println("<center>");
		out.println("<form name='frm' action='update' method='GET'>");
		
		out.println(" <h2>Update Product Data</h2>");
		out.println("<input type='hidden' value='"+ pid +"' name='pid' id='pid' placeholder='enter product id' ><br><br>");
		out.println("<input type='text' value='"+ pname +"' name='pname' id='name' placeholder='enter product name' ><br><br>");
		out.println("<input type='text' value='"+ pprice +"' name='pprice' id='price' placeholder='enter product price'> <br><br>");
		out.println("<input type='text' value='"+ cname +"' name='cname' id='contact' placeholder='enter company name' ><br><br>");
		out.println("<button type='submit'name='s'  class='sub' value='Update' >Update Product</button>");
		
		out.println("</form>");
		out.println("</center>");

		out.println("</body>");
		out.println("</html>");

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
