package ru.unlimit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><body><head><link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.w3schools.com/w3css/4/w3.css\"></head>");
		writer.println("<table class = \"table w3-table-all\" border = " + "1" + ">");
		writer.println("<tr class=\"w3-light-grey w3-hover-red\"><td>ID</td><td>Login</td><td>Name</td></tr>");
		
		Statement statement;
		try {
			source.DataBase.ConnectToDB();
			statement = source.DataBase.connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM `database`.users;");
			
			while(rs.next()) {
	            writer.println("<tr class=\"w3-light-grey w3-hover-red\"><td>" + rs.getInt("ID") +
	            		"</td><td>" + rs.getString("Login") + 
	            		"</td><td>" + rs.getString("Name") + 
	            		"</td></tr>");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
  	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
