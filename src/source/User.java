package source;

public class User {

    private int ID;
    private String Login;
    private String Name;

    public User(int ID, String Login, String Name){
        this.ID = ID;
        this.Login = Login;
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
