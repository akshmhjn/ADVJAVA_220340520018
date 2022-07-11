package com.cdac.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 * @WebServlet("/register.cdac")
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	

	
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "cdac");
		PreparedStatement st = conn.prepareStatement("insert into tbl_customer(id, name, username, password) values(?, ?, ?, ?)");
		st.setInt(1, id); 
		st.setString(2, name);
		st.setString(3, username);
		st.setString(4, password);
		st.executeUpdate();
		conn.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	PrintWriter out = response.getWriter();
	out.write("<html><body>");
	out.write("<h1>Registration successful!</h1>");
	out.write("</body></html>");

}
}
