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

import source.DataBase;
import source.MailingList;

@WebServlet("/CandidatesServlet")
public class CandidatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		System.out.println("юзер");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.w3schools.com/w3css/4/w3.css\"></head><body>");
		writer.println("<table class = \"table w3-table-all\" border = " + "1" + ">");
		writer.println("<tr class=\"w3-light-grey w3-hover-red\"><td>ID</td><td>Name</td><td>Description</td><td>Users</td></tr>");
		try {
			DataBase.ConnectToDB();
			Statement statement = source.DataBase.connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM `database`.mailing_lists;");
	        while(rs.next()) {
	            MailingList list = new MailingList(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("Users"));
	            if (list.getUsers().length() < 4) {
	            	writer.println("<tr class=\"w3-light-grey w3-hover-red\"><td>" + rs.getInt("ID") +
		            		"</td><td>" + rs.getString("Name") + 
		            		"</td><td>" + rs.getString("Description") + 
		            		"</td><td>" + rs.getString("Users") +
		            		"</td></tr>");
	            }
	        }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
