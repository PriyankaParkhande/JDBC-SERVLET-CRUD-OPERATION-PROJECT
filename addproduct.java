package org.productApp;
import org.services.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.services.ProductService;


@WebServlet("/addproduct")
public class addproduct extends HttpServlet {
	
//when we use action="" then form get submitted on same page and when we submit form on same page then we need to check button click
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		out.println("<br><br>");
		
		
		out.println("<html>");
		out.println("<head><title>Add New Product</title><link rel=\"icon\" href=\"https://www.bbassets.com/static/v2619/images/favicon.ico?v=2619\"  type=\"image/x-icon\"></link></head>");
		out.println("<body>");
		out.println("<form name='frm' action='' method='GET'>");

		out.println("<center>");
		out.println(" <h2>Add New Product</h2>");
		out.println("<input type='text' name='pname' id='name' placeholder='enter product name' ><br><br>");
		out.println("<input type='text' name='pprice' id='email' placeholder='enter product price\'> <br><br>");
		out.println("<input type='text' name='cname' id='contact' placeholder='enter company name' ><br><br>");
	
		out.println("<button type='submit'name='s' id=\"submit\" class='sub' >Add Product</button>");
		out.println("</center>");
		out.println("</form>");
String button=request.getParameter("s");
if(button!=null) {
	String pname=request.getParameter("pname");
	int pprice=Integer.parseInt(request.getParameter("pprice"));
	String cname=request.getParameter("cname");
	ProductDataAdd p=new ProductDataAdd();
	p.setPname(pname);
	p.setPprice(pprice);
	p.setCname(cname);
	ProductService ps=new ProductService();
	boolean b = true;
	try {
		b = ps.isProdSave(p);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		out.println("error is:"+e);
	}
	if(b) {
		out.println("<h1> Product added successfully.</h1>");
	}else {
		out.println("<h1> Some problem is their.</h1>");

	}
	
}
		out.println("</body>");
		out.println("</html>");
		
		//out.println("<input type=\"text\" name=\"pname\" id=\"name\" placeholder=\"enter product name\" ><br><span class=\"error\" id=\"nerror\"></span>\r\n"+ "");
		
	}

	

}
