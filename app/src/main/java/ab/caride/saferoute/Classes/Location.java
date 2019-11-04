package ab.caride.saferoute.Classes;

import android.content.Context;
import android.widget.Toast;

import ab.caride.saferoute.Controladores.StreetController;
import ab.caride.saferoute.Controladores.UserController;
import ab.caride.saferoute.TelasJava.TarefaPost;

public class Location extends Thread{
    public TarefaPost tarefaPost;
    public UserController user;
    Context context;
    public StreetController SControlller;
    int contador;

    public Location(Context context){
        this.context = context;
    }


    public String getLocation() {
        //Postar();
        thread.start();
        return "Voltou";
    }

    Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            SControlller = new StreetController(context);
            Street rua;
            contador = 0;

            boolean bool = true;

            while(1 == 1) {
                bool = !bool;
                int car = bool? 1:0;

                rua = SControlller.lista.get(car);
                try {


                    while(contador <= 100) {
                        Thread.sleep(5000);
                        tarefaPost = new TarefaPost();
                        tarefaPost.chamada = car;
                        tarefaPost.execute("Nome: " + rua.name + " " + "Latitude: " + rua.lat + " " + " Longitude: " + rua.lng);

                        contador++;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    });


}
