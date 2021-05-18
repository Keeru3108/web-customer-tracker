package com.myproject.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class Testdbservlet
 */
@WebServlet("/Testdbservlet")
public class Testdbservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//setup connection to the variable
		String user="hbstudent";
		String pass="hbstudent";
		String url="jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		
		Connection con;
		String driver="com.mysql.cj.jdbc.Driver";
		
    //get connection to database
		try {
			
			PrintWriter out=response.getWriter();
			out.println("connecting to database"+url);
			
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pass);
			
			out.println("connection succesful");
			
			con.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
	
	
	
	}
	

}
