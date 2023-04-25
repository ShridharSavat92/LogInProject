package com.ServletJspLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginservlet")
public class ServletLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "root");
			PreparedStatement ps=con.prepareStatement("select name from user where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=resp.getWriter();
			
			if(rs.next()) {
				RequestDispatcher rd=req.getRequestDispatcher("Welcome.jsp");
				rd.forward(req, resp);
			}
			else {
				//PrintWriter out=resp.getWriter();
				out.println("<font color=red size=18>Invalid credential!<br>");
				out.println("<a href=Login.jsp>try again!!..");
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
