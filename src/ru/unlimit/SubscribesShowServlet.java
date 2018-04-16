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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import source.DataBase;
import source.MailingList;
import source.User;

/**
 * Servlet implementation class SubscribesShowServlet
 */
@WebServlet("/SubscribesShowServlet")
public class SubscribesShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObservableList<MailingList> Lists = FXCollections.observableArrayList();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		int UserID;

		if ((request.getParameter("Subs") != null) && (request.getParameter("Subs") != ""))
		{
			writer.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.w3schools.com/w3css/4/w3.css\"></head><body><table class = \"table w3-table-all\" border = 1><tr><td>UserID</td><td>Subscribe</td></tr>");
			UserID = Integer.valueOf(request.getParameter("Subs"));
			try {
				source.DataBase.ConnectToDB();
				Statement statement = DataBase.connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM `database`.mailing_lists;");

				while(rs.next()) {
				    MailingList list = new MailingList(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("Users"));
				    Lists.add(list);
				}
				
				rs = statement.executeQuery("SELECT * FROM `database`.users;");

		        while(rs.next()) {
		            User user1 = new User(rs.getInt("ID"), rs.getString("Login"), rs.getString("Name"));
		            if (user1.getID() == UserID)
		            {
		                User user2 = new User(user1.getID(), user1.getLogin(), user1.getName());
		                for (MailingList List: Lists)
		                {
		                    if (List.getUsers().contains(String.valueOf(UserID))) {
		                        String ListName = List.getName();
		                        System.out.println(ListName);
		                        System.out.println(UserID);
		                        writer.println("<tr class=\"w3-light-grey w3-hover-red\"><td>" + UserID + "</td><td>" + ListName + "</td></tr>");
		                    }
		                }
		            }
		        }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			writer.println("</table></body></html>");
			writer.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
