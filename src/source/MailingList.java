package source;

public class MailingList {

     private int ID;
     private String Name;
     private String Description;
     private String Users;

    public MailingList(int ID, String Name, String Description, String Users){
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.Users = Users;
    }

    public String getUsers() {
        return Users;
    }

    public void setUsers(String users) {
        Users = users;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
