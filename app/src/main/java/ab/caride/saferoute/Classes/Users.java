package ab.caride.saferoute.Classes;

public class Users {

    public int id;
    public String name;
    public String user;
    public String password;
    public String ultimaAlteracao;

    public Users() {}


    public Users(int id, String name, String user, String password) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {

        String print = "id - " + String.valueOf(id) + " - " + String.valueOf(name);
        return print;
    }
}
