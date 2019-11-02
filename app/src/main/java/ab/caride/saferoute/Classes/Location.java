package ab.caride.saferoute.Classes;

import ab.caride.saferoute.Controladores.UserController;
import ab.caride.saferoute.TelasJava.TarefaPost;

public class Location extends Thread{
    public TarefaPost tarefaPost;
    public UserController user;

    public Location(){

    }


    public String getLocation() {
        //Postar();
        thread.start();
        return "Voltou";
    }

    Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            while(1 == 1) {
                try {
                    Thread.sleep(10000);
                    tarefaPost = new TarefaPost();
                    tarefaPost.chamada = 0;
                    tarefaPost.execute("Foi");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    });


}
