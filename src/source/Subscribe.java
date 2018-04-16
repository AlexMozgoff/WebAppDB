package source;

public class Subscribe {

    private int ID;
    private String Login;
    private String Name;
    private String Subscribes;

    Subscribe(int ID, String Login, String Name, String ListName){
        this.ID = ID;
        this.Login = Login;
        this.Name = Name;
        this.Subscribes = ListName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSubscribes() {
        return Subscribes;
    }

    public void setSubscribes(String subscribes) {
        Subscribes = subscribes;
    }
}
