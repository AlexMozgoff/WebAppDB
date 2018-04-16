package source;

import java.sql.*;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class DataBase {

    public static Connection connection;
    private final static String URL = "jdbc:mysql://localhost:3306/database?useSSL=true&verifyServerCertificate=false";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "root";

    public static void ConnectToDB(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            try {
            	Class.forName("com.mysql.jdbc.Driver");
            	} catch (ClassNotFoundException e) {
            		e.printStackTrace();
            	}	
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddMailingList(int ID, String Name, String Description, String Users) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `database`.`mailing_lists` (`ID`, `Name`, `Description`, `Users`) VALUES (?, ?, ?, ?);\n");
        statement.setInt(1, ID);
        statement.setString(2, Name);
        statement.setString(3, Description);
        statement.setString(4, Users);
        statement.executeUpdate();
    }

    public static void AddUser(int ID, String Login, String Name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `database`.`users` (`ID`, `Login`, `Name`) VALUES (?, ?, ?);\n");
        statement.setInt(1, ID);
        statement.setString(2, Login);
        statement.setString(3, Name);
        statement.executeUpdate();
    }

    public static void DeleteUserOnId(int ID)  throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM `database`.`users` WHERE `ID`=?;\n");
        statement.setInt(1, ID);
        statement.executeUpdate();
    }

    public static void DeleteMailingListOnId(int ID) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM `database`.`mailing_lists` WHERE `ID`=?;\n");
        statement.setInt(1, ID);
        statement.executeUpdate();
    }

    public static void ChangeMailingListOnId(int ID, String Name, String Description, String Users) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE `database`.`mailing_lists` SET `Name`=?, `Description`=?, `Users`=? WHERE `ID`=?;\n");
        statement.setInt(4, ID);
        statement.setString(1, Name);
        statement.setString(2, Description);
        statement.setString(3, Users);
        statement.executeUpdate();
    }

    public static void ChangeUserOnId(int ID, String Login, String Name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE `database`.`users` SET `Login`=?, `Name`=? WHERE `ID`=?;\n");
        statement.setInt(3, ID);
        statement.setString(1, Login);
        statement.setString(2, Name);
        statement.executeUpdate();
    }
    
    

    public static void showDB() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeQuery("select * from users");
    }
    
}
