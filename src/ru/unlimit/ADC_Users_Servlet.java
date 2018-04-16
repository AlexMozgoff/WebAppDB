package ru.unlimit;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.User;

@WebServlet("/ADC_Users_Servlet")
public class ADC_Users_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("A.D.C_Users.jsp").forward(request, response);
		String req = (request.getParameter("ADDID"));
		boolean bool = false;
		
		int userID = 0;
		String userLogin = "";
		String userName = "";
		if ((request.getParameter("ADDID").toString() != null) && ((request.getParameter("ADDID")).toString() != " ") && ((request.getParameter("ADDID")).toString() != "")) {
			userID = Integer.valueOf(request.getParameter("ADDID"));
			bool = true;
			if (request.getParameter("ADDLogin") != null) {
				userLogin = request.getParameter("ADDLogin");
				bool = true;
				if (request.getParameter("ADDName") != null) {
					userName = request.getParameter("ADDName");
					bool = true;
				}
			}
		}
		
			if (bool == true) {
			User user = new User(userID, userLogin, userName);	
				if ((user != null) && (userID != 0))
				{
					System.out.println("User not null");
					try {
						source.DataBase.ConnectToDB();
						PreparedStatement statement = source.DataBase.connection.prepareStatement("INSERT INTO `database`.`users` (`ID`, `Login`, `Name`) VALUES (?, ?, ?);\n");
						statement.setInt(1, user.getID());
						statement.setString(2, user.getLogin());
						statement.setString(3, user.getName());
						statement.executeUpdate();
						System.out.println("User added");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
	

		
		
		if ((request.getParameter("DELETEID") != null) && (request.getParameter("DELETEID") != ""))
		{
			try {
				source.DataBase.ConnectToDB();
				PreparedStatement statement = source.DataBase.connection.prepareStatement("DELETE FROM `database`.`users` WHERE `ID`=?;\n");
				statement.setInt(1, Integer.valueOf(request.getParameter("DELETEID")));
				statement.executeUpdate();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		int ChangeID = 0;
		String ChangeLogin = "";
		String ChangeName = "";
		if ((request.getParameter("CHANGEID") != null) && (request.getParameter("CHANGEID") != "")) {
			ChangeID = Integer.valueOf(request.getParameter("CHANGEID"));
			
			if ((request.getParameter("CHANGELogin") != null) && (request.getParameter("CHANGELogin") != ""))
				ChangeName = request.getParameter("CHANGELogin");
			
			if ((request.getParameter("CHANGEName") != null) && (request.getParameter("CHANGEName") != ""))
				ChangeName = request.getParameter("CHANGEName");
			

			
			try {
				source.DataBase.ConnectToDB();
				PreparedStatement statement = source.DataBase.connection.prepareStatement("UPDATE `database`.`users` SET `Login`=?, `Name`=? WHERE `ID`=?;\n");
				statement.setInt(3, ChangeID);
				statement.setString(1, ChangeLogin);
				statement.setString(2, ChangeName);
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
