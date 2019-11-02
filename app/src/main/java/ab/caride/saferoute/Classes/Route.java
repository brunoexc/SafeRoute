package ab.caride.saferoute.Classes;

public class Route {

    public int id;
    public String name;
    public String ruas;



    public Route(int id, String name, String ruas) {
        this.id = id;
        this.name = name;
        this.ruas = ruas;
    }

    @Override
    public String toString() {

        String print = "id - " + String.valueOf(id) + " - " + String.valueOf(name);
        return print;
    }




}
