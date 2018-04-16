package ru.unlimit;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.MailingList;

@WebServlet("/ADC_List_Servlet")
public class ADC_List_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("A.D.C_Mailing_List.jsp").forward(request, response);
		String req = request.getParameter("ADDID");
		boolean bool = false;
		
		int listID = 0;
		String listName = "";
		String listDescription = "";
		String listUsers = "";
		System.out.println(req);
		if ((request.getParameter("ADDID") != null) && ((request.getParameter("ADDID")) != "")) {
			listID = Integer.valueOf(request.getParameter("ADDID"));
			bool = true;
			if (request.getParameter("ADDName") != null) {
				listName = request.getParameter("ADDName");
				bool = true;
				if (request.getParameter("ADDDescription") != null) {
					listDescription = request.getParameter("ADDDescription");
					bool = true;
					if (request.getParameter("ADDUsers") != null) {
						listUsers = request.getParameter("ADDUsers");
					}
				}
			}
		}
		
			if (bool == true) {
			MailingList list = new MailingList(listID, listName, listDescription, listUsers);	
				if ((list != null) && (listID != 0))
				{
					System.out.println("User not null");
					try {
						source.DataBase.ConnectToDB();
						PreparedStatement statement = source.DataBase.connection.prepareStatement("INSERT INTO `database`.`mailing_lists` (`ID`, `Name`, `Description`, `Users`) VALUES (?, ?, ?, ?);\n");
						statement.setInt(1, list.getID());
						statement.setString(2, list.getName());
						statement.setString(3, list.getDescription());
						statement.setString(4, list.getUsers());
						statement.executeUpdate();
						System.out.println("List added");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
	

		
		
		if ((request.getParameter("DELETEID") != null) && (request.getParameter("DELETEID") != ""))
		{
			try {
				source.DataBase.ConnectToDB();
				PreparedStatement statement = source.DataBase.connection.prepareStatement("DELETE FROM `database`.`mailing_lists` WHERE `ID`=?;\n");
				statement.setInt(1, Integer.valueOf(request.getParameter("DELETEID")));
				statement.executeUpdate();
				System.out.println("pipipi");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		int ChangeID = 0;
		String ChangeName = "";
		String ChangeDescription = "";
		String ChangeUsers = "";
		if ((request.getParameter("CHANGEID") != null) && (request.getParameter("CHANGEID") != "")) {
			ChangeID = Integer.valueOf(request.getParameter("CHANGEID"));
			
			if ((request.getParameter("CHANGEName") != null) && (request.getParameter("CHANGEName") != ""))
				ChangeName = request.getParameter("CHANGEName");
			
			if ((request.getParameter("CHANGEDescription") != null) && (request.getParameter("CHANGEDescription") != ""))
				ChangeDescription = request.getParameter("CHANGEDescription");
			
			if ((request.getParameter("CHANGEUsers") != null) && (request.getParameter("CHANGEUsers") != ""))
				ChangeUsers = request.getParameter("CHANGEUsers");
			
			try {
				source.DataBase.ConnectToDB();
				PreparedStatement statement = source.DataBase.connection.prepareStatement("UPDATE `database`.`mailing_lists` SET `Name`=?, `Description`=?, `Users`=? WHERE `ID`=?;\n");
				statement.setInt(4, ChangeID);
				statement.setString(1, ChangeName);
				statement.setString(2, ChangeDescription);
				statement.setString(3, ChangeUsers);
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
