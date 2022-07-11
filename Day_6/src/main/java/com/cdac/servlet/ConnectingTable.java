package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectingTable
 */
@WebServlet("/ConnectingTable")
public class ConnectingTable extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jalgaon", "root", "cdac");
			String str="select * from userinfo ";
			Statement st=conn.createStatement();
			ResultSet set=st.executeQuery(str);
			PrintWriter out = response.getWriter();
			out.write("<html><body>");
			out.write("<h1>UserInfo Table</h1>");
			while(set.next())
			{
				
				String name=set.getString(1);
				String mobileno=set.getString(2);
				
				
				out.write("<h1> Username : "+name+" & Mobile No : "+mobileno+"</h1>");
			}
			out.write("</body></html>");
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}



}