package ab.caride.saferoute.Classes;

public class Users {

    public int id;
    public String name;
    public String user;
    public String pass_app;
    public String pass_rota;
    public String pass_emergencia;


    public Users() {}


    public Users(int id, String name, String user, String passapp, String passrota, String passemerg) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.pass_app = passapp;
        this.pass_rota = passrota;
        this.pass_emergencia = passemerg;
    }

    @Override
    public String toString() {

        String print = "id - " + String.valueOf(id) + " - " + String.valueOf(name);
        return print;
    }


}
