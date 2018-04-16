package source;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML public TextField AddMailingListId;
    @FXML public TextField AddMailingListName;
    @FXML public TextField AddMailingListDescription;
    @FXML public TextField AddMailingListUsers;

    @FXML public TextField AddUserId;
    @FXML public TextField AddUserLogin;
    @FXML public TextField AddUserName;

    @FXML public TextField DeleteId;
    @FXML public TextField DeleteMailingListId;

    @FXML public TextField ChangeListId;
    @FXML public TextField ChangeListName;
    @FXML public TextField ChangeListDescription;
    @FXML public TextField ChangeListUsers;

    @FXML public TextField ChangeUserId;
    @FXML public TextField ChangeUserLogin;
    @FXML public TextField ChangeUserName;

    @FXML public TableView<MailingList> MailingListTab;
    @FXML public TableColumn<MailingList, Integer> IDColumn;
    @FXML public TableColumn<MailingList, String> nameColumn;
    @FXML public TableColumn<MailingList, String> descriptionColumn;
    @FXML public TableColumn<MailingList, String> usersColumn;

    @FXML public TableView<User> UsersTab;
    @FXML public TableColumn<User, Integer> UserIdCol;
    @FXML public TableColumn<User, String> UserLoginCol;
    @FXML public TableColumn<User, String> UserNameCol;

    @FXML public TableView<MailingList> CandidatesTab;
    @FXML public TableColumn<MailingList, Integer> CandidatesID;
    @FXML public TableColumn<MailingList, String> CandidatesName;
    @FXML public TableColumn<MailingList, String> CandidatesDescription;
    @FXML public TableColumn<MailingList, String> CandidatesUsers;

    @FXML public TableView<Subscribe> SubscribeTab;
    @FXML public TextField SubscribesUserId;
    @FXML public TableColumn<Subscribe, Integer> SubscribesID;
    @FXML public TableColumn<Subscribe, String> SubscribesLogin;
    @FXML public TableColumn<Subscribe, String> SubscribesName;
    @FXML public TableColumn<Subscribe, String> SubscribesListName;

    @FXML private void AddMailingList() throws SQLException {
        DataBase.ConnectToDB();
        DataBase.AddMailingList(Integer.parseInt(AddMailingListId.getText()), AddMailingListName.getText(), AddMailingListDescription.getText(), AddMailingListUsers.getText());
        DataBase.connection.close();
        AddMailingListId.setText("");
        AddMailingListName.setText("");
        AddMailingListDescription.setText("");
        AddMailingListUsers.setText("");
        handleRefresh1();
    }

    @FXML private void AddUser()throws SQLException {
        DataBase.ConnectToDB();
        DataBase.AddUser(Integer.parseInt(AddUserId.getText()), AddUserLogin.getText(), AddUserName.getText());
        DataBase.connection.close();
        AddUserId.setText("");
        AddUserLogin.setText("");
        AddUserName.setText("");
        handleRefresh2();
    }

    @FXML private void DeleteUserOnId() throws SQLException {
        DataBase.ConnectToDB();
        DataBase.DeleteUserOnId(Integer.parseInt(DeleteId.getText()));
        DataBase.connection.close();
        DeleteId.setText("");
        handleRefresh2();
    }

    @FXML private void DeleteMailingListOnId() throws  SQLException {
        DataBase.ConnectToDB();
        DataBase.DeleteMailingListOnId(Integer.parseInt(DeleteMailingListId.getText()));
        DataBase.connection.close();
        DeleteMailingListId.setText("");
        handleRefresh1();
    }

    @FXML private void ChangeMailingListOnId() throws SQLException {
;;      DataBase.ConnectToDB();
        DataBase.ChangeMailingListOnId(Integer.parseInt(ChangeListId.getText()), ChangeListName.getText(), ChangeListDescription.getText(), ChangeListUsers.getText());
        DataBase.connection.close();
        ChangeListId.setText("");
        ChangeListName.setText("");
        ChangeListDescription.setText("");
        ChangeListUsers.setText("");
        handleRefresh1();
    }

    @FXML private void ChangeUserOnId() throws SQLException {
        DataBase.ConnectToDB();
        DataBase.ChangeUserOnId(Integer.parseInt(ChangeUserId.getText()), ChangeUserLogin.getText(), ChangeUserName.getText());
        DataBase.connection.close();
        ChangeUserId.setText("");
        ChangeUserLogin.setText("");
        ChangeUserName.setText("");
        handleRefresh2();
    }

    @FXML private void handleRefresh1() throws SQLException {
        ObservableList<MailingList> Lists = FXCollections.observableArrayList();
        DataBase.ConnectToDB();

        IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        usersColumn.setCellValueFactory(new PropertyValueFactory<>("Users"));

        Statement statement = DataBase.connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM `database`.mailing_lists;");

        while(rs.next()) {
            MailingList list = new MailingList(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("Users"));
            Lists.add(list);
        }
        MailingListTab.setItems(Lists);
    }

    @FXML private void handleRefresh2() throws SQLException{
        ObservableList<User> Users = FXCollections.observableArrayList();
        DataBase.ConnectToDB();

        UserIdCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        UserLoginCol.setCellValueFactory(new PropertyValueFactory<>("Login"));
        UserNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));

        Statement statement = DataBase.connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM `database`.users;");

        while(rs.next()) {
            User user = new User(rs.getInt("ID"), rs.getString("Login"), rs.getString("Name"));
            Users.add(user);
        }
        UsersTab.setItems(Users);
    }

    @FXML private void handleCandidates() throws SQLException {
        ObservableList<MailingList> Lists = FXCollections.observableArrayList();
        DataBase.ConnectToDB();

        CandidatesID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        CandidatesName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        CandidatesDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        CandidatesUsers.setCellValueFactory(new PropertyValueFactory<>("Users"));

        Statement statement = DataBase.connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM `database`.mailing_lists;");

        while(rs.next()) {
            MailingList list = new MailingList(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("Users"));
            if (list.getUsers().length() < 4) {
                Lists.add(list);
            }
            CandidatesTab.setItems(Lists);
        }
    }

    @FXML private void getSubscribes() throws SQLException {
        ObservableList<Subscribe> Subscribes = FXCollections.observableArrayList();
        ObservableList<MailingList> Lists = FXCollections.observableArrayList();
        User user;
        DataBase.ConnectToDB();
        int ID = Integer.parseInt(SubscribesUserId.getText());

        SubscribesID.setCellValueFactory(new PropertyValueFactory<Subscribe, Integer>("ID"));
        SubscribesLogin.setCellValueFactory(new PropertyValueFactory<Subscribe, String>("Login"));
        SubscribesListName.setCellValueFactory(new PropertyValueFactory<Subscribe, String>("Subscribes"));
        SubscribesName.setCellValueFactory(new PropertyValueFactory<Subscribe, String>("Name"));


        Statement statement = DataBase.connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM `database`.mailing_lists;");

        while(rs.next()) {
            MailingList list = new MailingList(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("Users"));
            Lists.add(list);
        }

        rs = statement.executeQuery("SELECT * FROM `database`.users;");

        while(rs.next()) {
            User user1 = new User(rs.getInt("ID"), rs.getString("Login"), rs.getString("Name"));
            if (user1.getID() == ID)
            {
                user = new User(user1.getID(), user1.getLogin(), user1.getName());
                for (MailingList List: Lists)
                {
                    if (List.getUsers().contains(String.valueOf(ID))) {
                        String ListName = List.getName();
                        Subscribe subscribe = new Subscribe(user.getID(), user.getLogin(), user.getName(), ListName);
                        Subscribes.add(subscribe);
                    }
                }
            }
        }
        SubscribeTab.setItems(Subscribes);
    }
}
