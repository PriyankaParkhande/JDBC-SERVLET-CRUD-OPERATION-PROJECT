package org.productApp;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CRUD
 */
@WebServlet("/CRUD")
public class CRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("CRUD.html");
		r.include(request, response);
		out.println("<br><br>");
		String pname=request.getParameter("pname");
		String price=request.getParameter("price");
		String cname=request.getParameter("cname");
		
		try {
			com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/priya","root","Priya@3010");
			if(conn!=null) {
				PreparedStatement p=conn.prepareStatement("insert into product values('0', ? ,?,?)");
				p.setString(1, pname);
				p.setString(2, price);
				p.setString(3, cname);
								
				int value=p.executeUpdate();
				if(value>0) {
					out.println("product add success");
					
				}else {
					out.println("product add failed");
				}
				
			}else {
				out.println("error occurs");
			}
			
			
		}
		catch(Exception ex){
			out.println("error is"+ex);
			
		}
		
	}
	


}


