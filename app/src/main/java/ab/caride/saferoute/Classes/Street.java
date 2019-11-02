package ab.caride.saferoute.Classes;

public class Street {

    public int id;
    public String name;
    public double lat;
    public double lng;


    public Street(int id, String name, double lat, double lng) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;

    }

    @Override
    public String toString() {

        String print = "id - " + String.valueOf(id) + " - " + String.valueOf(name);
        return print;
    }





}
